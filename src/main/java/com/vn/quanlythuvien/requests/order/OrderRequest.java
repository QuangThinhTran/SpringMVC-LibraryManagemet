package com.vn.quanlythuvien.requests.order;

import lombok.Data;

@Data
public class OrderRequest {
    private Integer userId;
    private String address;
    private String phone;
    private String email;
    private String note;
}
