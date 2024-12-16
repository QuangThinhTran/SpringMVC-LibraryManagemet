package com.vn.quanlythuvien.repositories;

import com.vn.quanlythuvien.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book getBookById(int id);

    Optional<Book> getBookByTitle(String title);

    List<Book> getBookByAuthor(String author);
}