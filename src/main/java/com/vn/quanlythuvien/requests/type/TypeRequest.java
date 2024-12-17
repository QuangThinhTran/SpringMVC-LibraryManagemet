package com.vn.quanlythuvien.requests.type;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TypeRequest {
    @NotBlank(message = "Tên loại sách l�? bắt buộc")
    private String name;
}
