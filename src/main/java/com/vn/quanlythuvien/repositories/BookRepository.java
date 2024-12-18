package com.vn.quanlythuvien.repositories;

import com.vn.quanlythuvien.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findById(int id);

    Book getBookByTitle(String title);

    List<Book> getBookByAuthor(String author);

    @Query("SELECT b FROM Book b " +
            "WHERE b.title LIKE %:keyword% " +
            "OR b.author LIKE %:keyword% " +
            "Group by b.id, b.title, b.author")
    List<Book> searchBook(String keyword);
}
