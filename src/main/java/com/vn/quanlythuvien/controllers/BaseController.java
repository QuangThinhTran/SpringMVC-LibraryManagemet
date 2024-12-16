package com.vn.quanlythuvien.controllers;

import com.vn.quanlythuvien.services.interfaces.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public abstract class BaseController {
    protected String resource;

    private final ITypeService typeService;

    @Autowired
    public BaseController(ITypeService typeService) {
        this.typeService = typeService;
        resource = "";
    }

    @GetMapping("/index")
    public String indexView(Model model) {
        model.addAttribute("types", typeService.getAll());
        return resource + "/index";
    }

    @GetMapping("/create")
    public String createView(Model model) {
        model.addAttribute("types", typeService.getAll());
        return resource + "/create";
    }

    @GetMapping("/edit")
    public String editView(Model model) {
        model.addAttribute("types", typeService.getAll());
        return resource + "/edit";
    }
}
