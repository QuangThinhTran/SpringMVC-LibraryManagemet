package com.vn.quanlythuvien.services;

import com.vn.quanlythuvien.models.Order;
import com.vn.quanlythuvien.models.OrderDetail;
import com.vn.quanlythuvien.repositories.OrderDetailRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
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
    public OrderDetail saveOrderDetail(Order order, OrderDetailRequest orderDetailRequest) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(order.getId());
        orderDetail.setBookId(orderDetailRequest.getBookId());
        orderDetail.setQuantity(orderDetailRequest.getQuantity());
        orderDetail.setPrice(orderDetailRequest.getPrice());
        orderDetail.setUserId(order.getUserId());
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void deleteOrderDetail(Integer id) {
        orderDetailRepository.deleteById(id);
    }
}
