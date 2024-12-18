package com.vn.quanlythuvien.controllers;

import com.vn.quanlythuvien.common.routes;
import com.vn.quanlythuvien.models.User;
import com.vn.quanlythuvien.repositories.UserRepository;
import com.vn.quanlythuvien.requests.user.CustomerRequest;
import com.vn.quanlythuvien.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(routes.CUSTOMER)
public class CustomerController {

    private final IUserService userService;
    private final UserRepository userRepository;

    @Autowired
    public CustomerController(
            IUserService userService,
            UserRepository userRepository
    ) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping()
    public String index(Model model) {
        String keyword = "";
        model.addAttribute("customers", this.userService.getUserByRole("user"));
        model.addAttribute("keyword", keyword);
        return "customer/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new CustomerRequest());
        return "customer/create";
    }

    @PostMapping("/store")
    public String store(
            @ModelAttribute("customer") CustomerRequest request,
            Model model
    ) {
        this.userService.createUser(request);
        return "redirect:" + routes.CUSTOMER;
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable("id") int id,
            Model model
    ) {
        User customer = this.userRepository.findById(id);
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @PostMapping("/update/{id}")
    public String update(
            @PathVariable("id") int id,
            @ModelAttribute("customer") CustomerRequest request,
            Model model
    ) {
        this.userService.updateUser(id, request);
        return "redirect:" + routes.CUSTOMER;
    }

    @GetMapping("/search")
    public String search(
            @RequestParam(value = "keyword", required = false) String keyword,
            Model model
    ) {
        model.addAttribute("customers", this.userService.searchUser(keyword));
        model.addAttribute("keyword", keyword);
        return "customer/search";
    }

    @PostMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") int id,
            Model model
    ) {
        this.userService.deleteUser(id);
        return "redirect:" + routes.CUSTOMER;
    }
}