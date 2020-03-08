package com.example.demo.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, EDITOR;

    @Override
    public String getAuthority() {
        return null;
    }
}
