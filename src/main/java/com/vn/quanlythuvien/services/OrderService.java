package com.vn.quanlythuvien.services;

import com.vn.quanlythuvien.models.Book;
import com.vn.quanlythuvien.models.Order;
import com.vn.quanlythuvien.models.User;
import com.vn.quanlythuvien.repositories.BookRepository;
import com.vn.quanlythuvien.repositories.OrderRepository;
import com.vn.quanlythuvien.repositories.UserRepository;
import com.vn.quanlythuvien.requests.order.OrderRequest;
import com.vn.quanlythuvien.services.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public OrderService(
            OrderRepository orderRepository,
            UserRepository userRepository,
            BookRepository bookRepository
    ) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getAllOrdersDesc() {
        return orderRepository.getAllDesc();
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getOrdersByUserId(Integer userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public void saveOrder(OrderRequest orderRequest) {
        Order order = new Order();
        setUpOrder(order, orderRequest);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    private void setUpOrder(Order order, OrderRequest orderRequest) {
        System.out.println(orderRequest);
        User user = userRepository.findById(orderRequest.getCustomerId()).orElse(null);
        Book book = bookRepository.findById(orderRequest.getBookId()).orElse(null);
        book.setQuantity(book.getQuantity() - orderRequest.getQuantity());
        bookRepository.save(book);
        order.setUser(user);
        order.setBook(book);
        order.setPrice(orderRequest.getPrice());
        order.setQuantity(orderRequest.getQuantity());
//        order.setReturnDate(orderRequest.getReturnDate());
        orderRepository.save(order);
    }
}
