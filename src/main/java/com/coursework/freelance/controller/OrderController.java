package com.coursework.freelance.controller;

import com.coursework.freelance.entity.Order;
import com.coursework.freelance.service.OrderService;
import com.coursework.freelance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/orders")
    public String getOrders(Model model) {
        List<Order> orders = orderService.findAll();
        Collections.reverse(orders);
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/add_order")
    public String getAddOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "add_order";
    }

    @PostMapping("/add_order")
    public String orderProcessing(@Valid @ModelAttribute Order order,
                                  BindingResult bindingResult,
                                  Authentication authentication) {

        if (bindingResult.hasErrors()) {
            return "/add_order";
        }

        String userLogin = authentication.getName();
        order.setUser(userService.findByLogin(userLogin));
        order.setDate(LocalDate.now());
        order.setTime(LocalTime.now());
        orderService.save(order);
        return "redirect:/orders";
    }
}
