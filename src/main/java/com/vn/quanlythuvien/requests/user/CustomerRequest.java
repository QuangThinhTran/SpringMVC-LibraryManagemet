package com.vn.quanlythuvien.requests.user;

import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class CustomerRequest {
    private Integer id;
    @NotBlank(message = "Tên là bắt buộc")
    private String name;

    @NotBlank(message = "Email là bắt buộc")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotBlank(message = "Số điện thoại là bắt buộc")
    private String phone;
}
