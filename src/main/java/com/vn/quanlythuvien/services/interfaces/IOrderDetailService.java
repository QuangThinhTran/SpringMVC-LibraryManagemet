package com.vn.quanlythuvien.services.interfaces;
import com.vn.quanlythuvien.models.OrderDetail;
import java.util.List;

public interface IOrderDetailService {
    List<OrderDetail> getAllOrderDetails();
    OrderDetail getOrderDetailById(Integer id);
    List<OrderDetail> getOrderDetailsByOrderId(Integer orderId);
    List<OrderDetail> getOrderDetailsByBookId(Integer bookId);
    OrderDetail saveOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(Integer id);
}
