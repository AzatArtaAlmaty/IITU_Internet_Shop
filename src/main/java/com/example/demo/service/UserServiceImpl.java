package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


//Получение username авторизированного пользователя
//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//logger.info("" + auth.getName());


@Service
public class UserServiceImpl{
    @Autowired
    private UserRepo repo;

    public boolean create(UserDto form) {
        UserEntity user = new UserEntity();
        user.setUsername(form.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        user.setActive(true);
        repo.save(user);
        return true;
    }

    public UserDto getCurrentUser(){
        return (UserDto) SecurityContextHolder.getContext().getAuthentication();
    }
}
