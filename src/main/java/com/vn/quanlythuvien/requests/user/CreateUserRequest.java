package com.vn.quanlythuvien.requests.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CreateUserRequest {
    @NotBlank(message = "Tên là bắt buộc")
    private String name;

    private String username;

    private String password;

    @NotBlank(message = "Email là bắt buộc")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotBlank(message = "Số điện thoại là bắt buộc")
    private String phone;
}
