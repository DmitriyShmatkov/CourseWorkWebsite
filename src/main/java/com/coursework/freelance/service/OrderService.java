package com.coursework.freelance.service;

import com.coursework.freelance.entity.Order;
import com.coursework.freelance.entity.User;
import com.coursework.freelance.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public boolean save(Order order) {
        orderRepository.save(order);
        return true;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
