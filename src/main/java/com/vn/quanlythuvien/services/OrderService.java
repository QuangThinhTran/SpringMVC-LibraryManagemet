package com.vn.quanlythuvien.services;

import com.vn.quanlythuvien.models.Order;
import com.vn.quanlythuvien.models.User;
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
    private final OrderDetailService orderDetailService;
    private final UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderDetailService orderDetailService,
                        UserRepository userRepository
    ) {
        this.orderRepository = orderRepository;
        this.orderDetailService = orderDetailService;
        this.userRepository = userRepository;
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
    public void saveOrder(OrderRequest orderRequest) {
        Order order = new Order();
        setUpOrder(order, orderRequest);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    private void setUpOrder(Order order, OrderRequest orderRequest) {
        User user = userRepository.findById(orderRequest.getUserId()).orElse(null);
        order.setUser(user);
//        order.setTotal(orderRequest.getTotal());
//        order.setStatus(orderRequest.getStatus());
//        order.setRentalDate(orderRequest.getRentalDate());
//        order.setReturnDate(orderRequest.getReturnDate());
        order.setOrderDetails(null);
        orderRepository.save(order);
    }
}
