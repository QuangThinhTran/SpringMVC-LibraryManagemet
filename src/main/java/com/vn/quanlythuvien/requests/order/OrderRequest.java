package com.vn.quanlythuvien.requests.order;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class OrderRequest {
    @NotNull(message = "Giá là bắt buộc")
    private double price;

//    @NotNull(message = "Ngày trả sách là bắt buộc")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date returnDate;

    @NotNull(message = "Số lượng là bắt buộc")
    private Integer quantity;

    private Integer customerId;
    private Integer bookId;
}
