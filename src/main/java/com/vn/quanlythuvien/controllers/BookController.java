package com.vn.quanlythuvien.controllers;

import com.vn.quanlythuvien.common.routes;
import com.vn.quanlythuvien.services.interfaces.ITypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(routes.BOOK)
public class BookController extends BaseController {

    public BookController(ITypeService typeService) {
        super(typeService);
        resource = routes.BOOK;
    }
}
