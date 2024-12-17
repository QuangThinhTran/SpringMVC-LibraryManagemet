package com.vn.quanlythuvien.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Component
public class Util {

    @Value("${file.upload.directory}")
    private String pathDir;

    public static String setSlug(String string) {
        return string.replaceAll("[^a-zA-Z0-9.-]", "-").toLowerCase();
    }

    /**
     * Upload file
     *
     * @param multipartFile - File to upload
     * @return - Slug of file
     * @throws IOException - Exception when upload file
     */
    public String uploadFile(MultipartFile multipartFile) throws IOException {
        // Lấy tên file và xóa ký tự đặc biệt trong tên file để tạo slug
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));

        // Tạo slug từ tên file
        String slug = setSlug(fileName);

        // Tạo file từ slug và đường dẫn
        // File.separator để tạo file trên cả windows và linux
        File file = new File(pathDir + File.separator + slug);
        // Lưu file vào đường dẫn vừa tạo
        multipartFile.transferTo(file);
        return slug;
    }
}
