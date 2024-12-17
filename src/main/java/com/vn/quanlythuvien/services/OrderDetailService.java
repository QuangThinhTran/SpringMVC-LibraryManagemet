package com.vn.quanlythuvien.services;

import com.vn.quanlythuvien.models.Book;
import com.vn.quanlythuvien.models.Order;
import com.vn.quanlythuvien.models.OrderDetail;
import com.vn.quanlythuvien.repositories.BookRepository;
import com.vn.quanlythuvien.repositories.OrderDetailRepository;

import java.util.List;
import java.util.Optional;

import com.vn.quanlythuvien.repositories.OrderRepository;
import com.vn.quanlythuvien.requests.order.OrderDetailRequest;
import com.vn.quanlythuvien.services.interfaces.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderDetailService(
            OrderDetailRepository orderDetailRepository,
            BookRepository bookRepository,
            OrderRepository orderRepository
    ) {
        this.orderDetailRepository = orderDetailRepository;
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail getOrderDetailById(Integer id) {
        return orderDetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderDetail> getOrderDetailsByOrderId(Integer orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }

    @Override
    public List<OrderDetail> getOrderDetailsByBookId(Integer bookId) {
        return orderDetailRepository.findByBookId(bookId);
    }

    @Override
    public OrderDetail saveOrderDetail(OrderDetailRequest orderDetailRequest) {

        Optional<Book> book = bookRepository.findById(orderDetailRequest.getBookId());
        Order order = orderRepository.findById(orderDetailRequest.getOrderId()).orElse(null);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(order);
//        orderDetail.setBook(book);
        orderDetail.setQuantity(orderDetailRequest.getQuantity());
//        orderDetail.setPrice(book.getPrice() * orderDetailRequest.getQuantity());
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void deleteOrderDetail(Integer id) {
        orderDetailRepository.deleteById(id);
    }
}
