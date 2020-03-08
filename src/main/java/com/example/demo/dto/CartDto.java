package com.example.demo.dto;

import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartDto {
    private String id;
    private Integer cost;
    private List<ItemDto> items;
    private UserDto user;
}
