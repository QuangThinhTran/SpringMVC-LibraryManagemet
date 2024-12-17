package com.vn.quanlythuvien.services.interfaces;

import com.vn.quanlythuvien.models.Book;
import com.vn.quanlythuvien.requests.book.BookRequest;

public interface IBookService {
    void createBook(BookRequest request, String pathFile);

    Book getBookById(int id);

    void updateBook(int id, BookRequest request, String pathFile);

    void deleteBook(int id);
}
