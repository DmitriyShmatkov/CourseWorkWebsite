package com.coursework.freelance.controller;

import com.coursework.freelance.entity.Role;
import com.coursework.freelance.entity.User;
import com.coursework.freelance.entity.Worker;
import com.coursework.freelance.service.UserService;
import com.coursework.freelance.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private WorkerService workerService;

    @GetMapping("/myaccount")
    public String getMyAccountPage(Model model, Authentication authentication) {
        String login = authentication.getName();
        User user = userService.findByLogin(login);
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("orders", user.getOrders());
            model.addAttribute("role", new Role(1L, "ROLE_USER"));
        } else {
            Worker worker = workerService.findByLogin(login);
            if (worker != null) {
                model.addAttribute("user", worker);
                model.addAttribute("role", new Role(2L, "ROLE_WORKER"));
            }
        }

        return "myaccount";
    }
}
