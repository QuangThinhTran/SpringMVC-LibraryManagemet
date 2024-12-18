package com.vn.quanlythuvien.controllers;

import com.vn.quanlythuvien.common.Util;
import com.vn.quanlythuvien.common.routes;
import com.vn.quanlythuvien.models.Book;
import com.vn.quanlythuvien.repositories.BookRepository;
import com.vn.quanlythuvien.repositories.TypeRepository;
import com.vn.quanlythuvien.requests.book.BookRequest;
import com.vn.quanlythuvien.services.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping(routes.BOOK)
public class BookController {

    private final IBookService bookService;
    private final TypeRepository typeRepository;
    private final BookRepository bookRepository;
    private final Util util;

    @Autowired
    public BookController(
            IBookService bookService,
            TypeRepository typeRepository,
            BookRepository bookRepository,
            Util util
    ) {
        this.bookService = bookService;
        this.typeRepository = typeRepository;
        this.bookRepository = bookRepository;
        this.util = util;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", this.bookRepository.findAll());
        return "book/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new BookRequest());
        model.addAttribute("types", this.typeRepository.findAll());
        return "book/create";
    }

    @PostMapping("/store")
    public String store(
            @ModelAttribute("book") BookRequest request,
            Model model
    ) throws IOException {
        String pathFile = util.uploadFile(request.getImage());
        request.setImage(null);
        this.bookService.createBook(request, pathFile);
        return "redirect:/book";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Book book = this.bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book/edit";
    }

    @PutMapping("/update/{id}")
    public String update(
            @PathVariable("id") int id,
            @ModelAttribute("book") BookRequest request,
            Model model
    ) throws IOException {
        String pathFile = util.uploadFile(request.getImage());
        request.setImage(null);
        this.bookService.updateBook(id, request, pathFile);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        this.bookService.deleteBook(id);
        return "redirect:/book";
    }

    @GetMapping("/search")
    public String search(
            @RequestParam("keyword", required = false) String keyword
            Model model) {
        model.addAttribute("books", this.bookService.search(keyword));
        return "book/index";
    }
}