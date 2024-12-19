package com.vn.quanlythuvien.controllers;

import com.vn.quanlythuvien.common.routes;
import com.vn.quanlythuvien.models.Order;
import com.vn.quanlythuvien.models.Role;
import com.vn.quanlythuvien.repositories.BookRepository;
import com.vn.quanlythuvien.repositories.RoleRepository;
import com.vn.quanlythuvien.repositories.UserRepository;
import com.vn.quanlythuvien.requests.order.OrderRequest;
import com.vn.quanlythuvien.services.OrderService;
import com.vn.quanlythuvien.services.interfaces.ITypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(routes.ORDER)
public class OrderController {

    private final OrderService orderService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BookRepository bookRepository;

    @Autowired
    public OrderController(
            ITypeService typeService, OrderService orderService, UserRepository userRepository,
            RoleRepository roleRepository, BookRepository bookRepository
    ) {
        this.orderService = orderService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public String listOrders(Model model) {
        List<Order> orders = orderService.getAllOrdersDesc();
        model.addAttribute("orders", orders);
        return "order/index";
    }

    @GetMapping("/create")
    public String createOrderForm(
            Model model
    ) {
        Role role = roleRepository.findByName("user");
        model.addAttribute("order", new OrderRequest());
        model.addAttribute("customers", userRepository.getUserByRole(role));
        model.addAttribute("books", bookRepository.findAll());
        return "order/create";
    }

    @PostMapping("/store")
    public String createOrder(
            @ModelAttribute("order") @Valid OrderRequest order,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            Role role = roleRepository.findByName("user");
            model.addAttribute("customers", userRepository.getUserByRole(role));
            model.addAttribute("books", bookRepository.findAll());
            return "order/create";
        }
        orderService.saveOrder(order);
        return "redirect:" + routes.ORDER;
    }
}
