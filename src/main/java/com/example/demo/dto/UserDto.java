package com.example.demo.dto;

import com.example.demo.entity.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class UserDto {
    private String id;
    private String username;
    private String password;
    private boolean active;
    private Role role;
}
