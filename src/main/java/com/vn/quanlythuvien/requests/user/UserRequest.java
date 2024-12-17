package com.vn.quanlythuvien.requests.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRequest {
    @NotBlank(message = "Tên l�? bắt buộc")
    private String name;

    private String username;

    private String password;

    @NotBlank(message = "Email l�? bắt buộc")
    @Email(message = "Email không hợp l�?")
    private String email;

    @NotBlank(message = "S�? điện thoại l�? bắt buộc")
    private String phone;
}
