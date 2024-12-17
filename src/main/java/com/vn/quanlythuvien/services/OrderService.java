package com.vn.quanlythuvien.services;

import com.vn.quanlythuvien.models.Order;
import com.vn.quanlythuvien.repositories.OrderRepository;
import com.vn.quanlythuvien.services.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailService orderDetailService;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderDetailService orderDetailService) {
        this.orderRepository = orderRepository;
        this.orderDetailService = orderDetailService;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
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
    public Order saveOrder(OrderRequest order) {
        
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    private void setUpOrder(Order order, OrderRequest orderRequest) {W
        order.setUserId(orderRequest.getUserId());
        order.setTotal(orderRequest.getTotal());
        order.setStatus(orderRequest.getStatus());
        order.setRentalDate(orderRequest.getRentalDate());
        order.setReturnDate(orderRequest.getReturnDate());
        order.setOrderDetails(null);
        orderRepository.save(order);
    }
}
