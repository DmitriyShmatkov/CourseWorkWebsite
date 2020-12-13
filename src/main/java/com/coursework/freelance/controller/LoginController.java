package com.coursework.freelance.controller;

import com.coursework.freelance.entity.User;
import com.coursework.freelance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
}
