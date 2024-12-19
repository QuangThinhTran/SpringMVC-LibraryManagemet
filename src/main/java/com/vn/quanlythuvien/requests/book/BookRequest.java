package com.vn.quanlythuvien.requests.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class BookRequest {
    @NotBlank(message = "Tiêu đề là bắt buộc")
    private String title;

    @NotBlank(message = "Tác giả là bắt buộc")
    private String author;

    @NotNull(message = "Giá là bắt buộc")
    private Double price;

    @NotNull(message = "Số lượng là bắt buộc")
    private Integer quantity;

    @NotNull(message = "Năm xuất bản là bắt buộc")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yearOfPublication;

    private int typeId;

    private String description;
    private MultipartFile image;
}
