package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl service;

    @PostMapping("/create")
    public String register(UserDto dto) {
        boolean result = service.create(dto);
        return "redirect:/admin";
    }
}
