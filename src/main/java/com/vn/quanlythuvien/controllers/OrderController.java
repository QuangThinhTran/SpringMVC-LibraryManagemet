package com.vn.quanlythuvien.controllers;

import com.vn.quanlythuvien.common.routes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(routes.ORDER)
public class OrderController extends BaseController {

    public OrderController() {
        resource = routes.ORDER;
    }
}
