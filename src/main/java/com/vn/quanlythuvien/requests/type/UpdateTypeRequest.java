package com.vn.quanlythuvien.requests.type;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateTypeRequest {
    @NotBlank(message = "Tên loại sách là bắt buộc")
    private String name;
}
