package com.vn.quanlythuvien.controllers;

import com.vn.quanlythuvien.models.User;
import com.vn.quanlythuvien.requests.AuthRequest;
import com.vn.quanlythuvien.services.interfaces.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final IUserService userService;

    @Autowired
    public AuthController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("auth", new AuthRequest());
        return "auth/login"; // Return the correct view name
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            Model model
    ) {
        model.addAttribute("message", "User registered successfully");
        return "index";
    }

   @PostMapping("/handle-login")
   public String login(
           @ModelAttribute("auth") AuthRequest request,
           Model model
   ) {
       System.out.println("user :" + request.getPassword());
       User user = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
       System.out.println(user != null);
       if (user != null) {
           model.addAttribute("user", user);
           return "redirect:/";
       } else {
           model.addAttribute("error", "Invalid username or password");
           return "/123";
       }
   }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}