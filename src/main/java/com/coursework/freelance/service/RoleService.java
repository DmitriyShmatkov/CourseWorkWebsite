package com.coursework.freelance.service;

import com.coursework.freelance.entity.Role;
import com.coursework.freelance.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
}
