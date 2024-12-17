package com.vn.quanlythuvien.requests.order;

import lombok.Data;

@Data
public class OrderDetailRequest {
    private Integer orderId;
    private Integer bookId;
    private Integer quantity;
    private Double price;
}