package com.vn.quanlythuvien.requests.order;

import lombok.Data;

@Data
public class OrderRequest {

    @NotNull(message = "Số lượng là bắt buộc")
    private Integer quantity;

    @NotNull(message = "Giá là bắt buộc")
    private double price;

    @NotNull(message = "Ngày trả sách là bắt buộc")
    private Date returnDate;
}
