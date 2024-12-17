package com.vn.quanlythuvien.controllers;

import com.vn.quanlythuvien.common.routes;
import com.vn.quanlythuvien.models.Order;
import com.vn.quanlythuvien.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(routes.ORDER)
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    public OrderController() {
        resource = routes.ORDER;
    }

    @GetMapping
    public String listOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "order/list";
    }

    @GetMapping("/{id}")
    public String getOrder(@PathVariable("id") Long id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "order/view";
    }

    @GetMapping("/create")
    public String createOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "order/create";
    }

    @PostMapping
    public String createOrder(@ModelAttribute Order order) {
        orderService.saveOrder(order);
        return "redirect:" + routes.ORDER;
    }

    @GetMapping("/edit/{id}")
    public String editOrderForm(@PathVariable("id") Long id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "order/edit";
    }

    @PostMapping("/update/{id}")
    public String updateOrder(@PathVariable("id") Long id, @ModelAttribute Order order) {
        order.setId(id);
        orderService.updateOrder(order);
        return "redirect:" + routes.ORDER;
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return "redirect:" + routes.ORDER;
    }
}
