package com.example.demo.dto;

import com.example.demo.entity.CartEntity;
import com.example.demo.entity.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class UserDto {
    private UUID id;
    private String username;
    private String password;
    private boolean active;
    private Role role;
    private String token;
    private List<UUID> carts;
}
