package com.vn.quanlythuvien.services.interfaces;

import com.vn.quanlythuvien.models.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAllOrders();
    Order getOrderById(Integer id);
    List<Order> getOrdersByUserId(Integer userId);
    Order saveOrder(Order order);
    void deleteOrder(Integer id);
}
