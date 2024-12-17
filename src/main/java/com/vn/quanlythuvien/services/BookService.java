package com.vn.quanlythuvien.services;

import com.vn.quanlythuvien.models.Book;
import com.vn.quanlythuvien.models.Type;
import com.vn.quanlythuvien.repositories.BookRepository;
import com.vn.quanlythuvien.repositories.TypeRepository;
import com.vn.quanlythuvien.requests.book.BookRequest;
import com.vn.quanlythuvien.services.interfaces.IBookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {

    private final BookRepository bookRepository;
    private final TypeRepository typeRepository;

    public BookService(BookRepository bookRepository, TypeRepository typeRepository) {
        this.bookRepository = bookRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public void createBook(BookRequest request, String pathFile) {
        setUpBook(new Book(), request, pathFile);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void updateBook(int id, BookRequest request, String pathFile) {
        Book book = bookRepository.findById(id);
        setUpBook(book, request, pathFile);
    }

    @Override
    public void deleteBook(int id) {
        Book book = bookRepository.findById(id);
        bookRepository.delete(book);
    }

    private void setUpBook(Book book, BookRequest request, String pathFile) {
        Type type = typeRepository.getTypeById(request.getTypeId());

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setType(type);
        book.setPrice(request.getPrice());
        book.setDescription(request.getDescription());
        if (pathFile != null) {
            book.setImage(pathFile);
        }
        book.setQuantity(request.getQuantity());
        book.setYearOfPublication(request.getYearOfPublication());
        bookRepository.save(book);
    }
}
