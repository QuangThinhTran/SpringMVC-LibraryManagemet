package com.vn.quanlythuvien.controllers;

import com.vn.quanlythuvien.common.routes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(routes.TYPE)
public class TypeController extends BaseController {

    public TypeController() {
        resource = routes.TYPE;
    }
}
