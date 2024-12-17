package com.vn.quanlythuvien.controllers;

import com.vn.quanlythuvien.common.routes;
import com.vn.quanlythuvien.models.Order;
import com.vn.quanlythuvien.requests.order.OrderRequest;
import com.vn.quanlythuvien.services.OrderService;
import com.vn.quanlythuvien.services.interfaces.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(routes.ORDER)
public class OrderController extends BaseController {

    private final OrderService orderService;

    @Autowired
    public OrderController(ITypeService typeService, OrderService orderService) {
        super(typeService);
        resource = routes.ORDER;
        this.orderService = orderService;
    }

    @GetMapping
    public String listOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "order/list";
    }

    @GetMapping("/{id}")
    public String getOrder(@PathVariable("id") Integer id, Model model) {
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
    public String createOrder(@ModelAttribute OrderRequest order) {
        orderService.saveOrder(order);
        return "redirect:" + routes.ORDER;
    }

    @GetMapping("/edit/{id}")
    public String editOrderForm(@PathVariable("id") Integer id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "order/edit";
    }

    @PostMapping("/update/{id}")
    public String updateOrder(@PathVariable("id") Integer id, @ModelAttribute Order order) {
        return "redirect:" + routes.ORDER;
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") Integer id) {
        orderService.deleteOrder(id);
        return "redirect:" + routes.ORDER;
    }
}
