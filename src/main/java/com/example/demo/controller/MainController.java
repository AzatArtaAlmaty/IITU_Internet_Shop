package com.example.demo.controller;

import com.example.demo.entity.ItemEntity;
import com.example.demo.repo.ItemRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private ItemRepo repo;
    @Value("${spring.profiles.active}")
    private String profiles;

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("isDevMode", "dev".equals(profiles));
        return "index";
    }
}
