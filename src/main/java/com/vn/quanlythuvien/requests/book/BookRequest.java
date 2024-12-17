package com.vn.quanlythuvien.requests.book;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class BookRequest {
    @NotBlank(message = "Tiêu đ�? l�? bắt buộc")
    private String title;

    @NotBlank(message = "Tác giả l�? bắt buộc")
    private String author;

    @NotNull(message = "Giá l�? bắt buộc")
    private Double price;

    @NotNull(message = "S�? lượng l�? bắt buộc")
    private Integer quantity;

    @NotBlank(message = "Năm xuất bản l�? bắt buộc")
    private Date yearOfPublication;

    @NotNull(message = "Loại sách l�? bắt buộc")
    private Integer typeId;

    private String description;
    private String image;
}
