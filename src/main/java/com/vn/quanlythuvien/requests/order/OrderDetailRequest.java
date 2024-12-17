package com.vn.quanlythuvien.requests.order;

@Data
public class OrderDetailRequest {
    private Integer orderId;
    private Integer bookId;
    private Integer quantity;
    private Double price;
}