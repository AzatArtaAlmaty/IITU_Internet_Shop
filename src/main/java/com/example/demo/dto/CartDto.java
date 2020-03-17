package com.example.demo.dto;

import com.example.demo.entity.CartItems;
import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartDto {
    private String id;
    private Integer cost;
    private List<UUID> items;
    private UUID user;
}
