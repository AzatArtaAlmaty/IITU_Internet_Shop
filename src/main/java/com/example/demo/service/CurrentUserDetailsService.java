package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;


    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = repo.findByUsername(email);
        user.setActive(true);
        return new CurrentUser(user);
    }
}
