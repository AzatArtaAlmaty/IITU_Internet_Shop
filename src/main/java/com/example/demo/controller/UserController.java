package com.example.demo.controller;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.dto.UserDto;
import com.example.demo.service.CurrentUser;
import com.example.demo.service.CurrentUserDetailsService;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl service;


    @PostMapping("/create")
    public Boolean register(UserDto dto) {
//        service.create(dto);
//        return "redirect:/admin";
        return service.create(dto);
    }

    @PostMapping("/auth")
    @ResponseBody
    public String createAuthenticationToken(@RequestBody UserDto authenticationRequest) throws Exception {
        return service.auth(authenticationRequest);
    }

}
