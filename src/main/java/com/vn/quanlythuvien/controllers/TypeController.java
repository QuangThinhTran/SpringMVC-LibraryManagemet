package com.vn.quanlythuvien.controllers;

import com.vn.quanlythuvien.common.routes;
import com.vn.quanlythuvien.requests.type.CreateTypeRequest;
import com.vn.quanlythuvien.services.interfaces.ITypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(routes.TYPE)
public class TypeController extends BaseController {

    private final ITypeService typeService;

    public TypeController(ITypeService typeService) {
        resource = routes.TYPE;
        this.typeService = typeService;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("type", new CreateTypeRequest());
        return "type/create";
    }

    @PostMapping("/store")
    public String store(
            @ModelAttribute("type") CreateTypeRequest request,
            Model model
    ) {
        this.typeService.createType(request);
        model.addAttribute("message", "Type created successfully");
        return "redirect:/types";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        CreateTypeRequest type = this.typeService.getTypeById(id);
        model.addAttribute("type", type);
        return "type/edit";
    }

    @PostMapping("/update/{id}")
    public String update(
            @PathVariable("id") int id,
            @ModelAttribute("type") CreateTypeRequest request,
            Model model
    ) {
        this.typeService.updateType(id, request);
        model.addAttribute("message", "Type updated successfully");
        return "redirect:/types";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("typeId", id);
        return "type/delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        this.typeService.deleteType(id);
        model.addAttribute("message", "Type deleted successfully");
        return "redirect:/types";
    }
}