package com.vn.quanlythuvien.services.interfaces;
import com.vn.quanlythuvien.models.OrderDetail;
import com.vn.quanlythuvien.requests.order.OrderDetailRequest;

import java.util.List;

public interface IOrderDetailService {
    List<OrderDetail> getAllOrderDetails();
    OrderDetail getOrderDetailById(Integer id);
    List<OrderDetail> getOrderDetailsByOrderId(Integer orderId);
    List<OrderDetail> getOrderDetailsByBookId(Integer bookId);
    OrderDetail saveOrderDetail(OrderDetailRequest orderDetailRequest);
    void deleteOrderDetail(Integer id);
}
