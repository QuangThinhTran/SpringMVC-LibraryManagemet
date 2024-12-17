package com.vn.quanlythuvien.requests.book;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class BookRequest {
//    @NotBlank(message = "Tiêu đề là bắt buộc")
    private String title;

//    @NotBlank(message = "Tác giả là bắt buộc")
    private String author;

//    @NotNull(message = "Giá là bắt buộc")
    private Double price;

//    @NotNull(message = "Số lượng là bắt buộc")
    private Integer quantity;

//    @NotBlank(message = "Năm xuất bản là bắt buộc")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yearOfPublication;

//    @NotNull(message = "Loại sách là bắt buộc")
    private Integer typeId;

    private String description;
    private MultipartFile image;
}
