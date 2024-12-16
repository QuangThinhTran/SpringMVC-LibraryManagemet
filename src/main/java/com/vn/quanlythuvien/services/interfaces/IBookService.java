package com.vn.quanlythuvien.services.interfaces;

import com.vn.quanlythuvien.requests.book.CreateBookRequest;

public interface IBookService {
    void createBook(CreateBookRequest request);
    void updateBook(int id, CreateBookRequest request);
    void deleteBook(int id);
}
