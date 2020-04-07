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
    private UUID id;
    private Integer cost;
    private List<CartItemsDto> items;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String city;
    private String region;
    private String postIndex;
}
