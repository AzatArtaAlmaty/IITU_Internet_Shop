package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.UserEntity;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.UUID;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private UserEntity user;

    public CurrentUser(UserEntity user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }


    public UserEntity getUser() {
        return user;
    }

    public UUID getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }

}
