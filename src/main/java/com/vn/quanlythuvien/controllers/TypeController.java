package com.vn.quanlythuvien.controllers;

import com.vn.quanlythuvien.common.routes;
import com.vn.quanlythuvien.models.Type;
import com.vn.quanlythuvien.repositories.TypeRepository;
import com.vn.quanlythuvien.requests.type.TypeRequest;
import com.vn.quanlythuvien.services.interfaces.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping(routes.TYPE)
public class TypeController {

    private final ITypeService typeService;
    private final TypeRepository typeRepository;

    @Autowired
    public TypeController(ITypeService typeService, TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
        this.typeService = typeService;
    }

    @GetMapping()
    public String index(Model model) {
        String keyword = "";
        model.addAttribute("types", this.typeRepository.findAll());
        model.addAttribute("keyword", keyword);
        return "type/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("type", new TypeRequest());
        return "type/create";
    }

    @PostMapping("/store")
    public String store(
            @ModelAttribute("type") @javax.validation.Valid TypeRequest request,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "type/create";
        }
        this.typeService.createType(request);
        return "redirect:/type";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Type type = this.typeRepository.findById(id);
        model.addAttribute("type", type);
        return "type/edit";
    }

    @PostMapping("/update/{id}")
    public String update(
            @PathVariable("id") int id,
            @ModelAttribute("type") @Valid TypeRequest request,
            Model model,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "type/edit";
        }
        this.typeService.updateType(id, request);
        return "redirect:/type";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        this.typeService.deleteType(id);
        return "redirect:/type";
    }
}