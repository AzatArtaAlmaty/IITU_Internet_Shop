package com.example.demo.controller;

import com.example.demo.repo.ItemRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MainController {
    @Autowired
    private ItemRepo repo;
    @Value("${spring.profiles.active:prod}")
    private String profiles;

    private     Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping(value = "/")
    public String index(Model model) throws IOException {
        model.addAttribute("isDevMode", "dev".equals(profiles));
        return "index";
    }
}
