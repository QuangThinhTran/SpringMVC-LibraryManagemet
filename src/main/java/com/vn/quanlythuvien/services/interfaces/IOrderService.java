package com.vn.quanlythuvien.services.interfaces;

import com.vn.quanlythuvien.models.Order;
import com.vn.quanlythuvien.requests.order.OrderRequest;

import java.util.List;

public interface IOrderService {
    List<Order> getAllOrders();
    Order getOrderById(Integer id);
    List<Order> getOrdersByUserId(Integer userId);
    void saveOrder(OrderRequest orderRequest);
    void deleteOrder(Integer id);
    List<Order> getAllOrdersDesc();
}
