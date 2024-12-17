package com.vn.quanlythuvien.controllers;

import com.vn.quanlythuvien.common.routes;
import com.vn.quanlythuvien.requests.book.CreateBookRequest;
import com.vn.quanlythuvien.services.interfaces.IBookService;
import com.vn.quanlythuvien.services.interfaces.ITypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(routes.BOOK)
public class BookController extends BaseController {

    private final IBookService bookService;

    public BookController(ITypeService typeService, IBookService bookService) {
        super(typeService);
        resource = routes.BOOK;
        this.bookService = bookService;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new CreateBookRequest());
        return "book/create";
    }

    @PostMapping("/store")
    public String store(
            @ModelAttribute("book") CreateBookRequest request,
            Model model
    ) {
        this.bookService.createBook(request);
        model.addAttribute("message", "Book created successfully");
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        CreateBookRequest book = this.bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book/edit";
    }

    @PostMapping("/update/{id}")
    public String update(
            @PathVariable("id") int id,
            @ModelAttribute("book") CreateBookRequest request,
            Model model
    ) {
        this.bookService.updateBook(id, request);
        model.addAttribute("message", "Book updated successfully");
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("bookId", id);
        return "book/delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        this.bookService.deleteBook(id);
        model.addAttribute("message", "Book deleted successfully");
        return "redirect:/books";
    }
}