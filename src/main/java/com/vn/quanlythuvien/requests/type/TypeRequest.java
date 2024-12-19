package com.vn.quanlythuvien.requests.type;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;

@Data
public class TypeRequest {
    @NotBlank(message = "Tên loại sách là bắt buộc")
    private String name;
}
