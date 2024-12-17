package com.vn.quanlythuvien.services;

import com.vn.quanlythuvien.models.Book;
import com.vn.quanlythuvien.models.Type;
import com.vn.quanlythuvien.repositories.BookRepository;
import com.vn.quanlythuvien.repositories.TypeRepository;
import com.vn.quanlythuvien.requests.book.BookRequest;
import com.vn.quanlythuvien.services.interfaces.IBookService;

public class BookService implements IBookService {

    private final BookRepository bookRepository;
    private final TypeRepository typeRepository;

    public BookService(BookRepository bookRepository, TypeRepository typeRepository) {
        this.bookRepository = bookRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public void createBook(BookRequest request) {
        setUpBook(new Book(), request);
    }

    @Override
    public void updateBook(int id, BookRequest request) {
        Book book = bookRepository.getBookById(id);
        setUpBook(book, request);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    private void setUpBook(Book book, BookRequest request) {
        Type type = typeRepository.getTypeById(request.getTypeId());

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setType(type);
        book.setPrice(request.getPrice());
        book.setDescription(request.getDescription());
        book.setImage(request.getImage());
        book.setQuantity(request.getQuantity());
        book.setYearOfPublication(request.getYearOfPublication());
        bookRepository.save(book);
    }
}
