package com.example.demo.mapper;


import com.example.demo.dto.CartDto;
import com.example.demo.dto.CartItemsDto;
import com.example.demo.entity.CartEntity;
import com.example.demo.entity.CartItems;
import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CartMapper {
    public static CartEntity CartDtoInEntity(CartDto dto, UserEntity user) {
        CartEntity cart = new CartEntity();
        cart.setCost(dto.getCost());
        System.out.println(cart.getCost());
        cart.setUser(user);
        return cart;
    }

    public static CartDto CartEntityInDto(CartEntity dto) {
        CartDto cart = new CartDto();
        cart.setId(dto.getId());
        cart.setCost(dto.getCost());
        cart.setUser(dto.getUser().getId());
        cart.setItems(CartItemsMapper.ListEntityToDto(dto.getItems()));
        return cart;
    }


//    public static List<CartDto> ListCartEntityInDto(List<CartEntity> dtos) {
//        List<CartDto> cat = new ArrayList<>();
////        for (int i = 0; i < dtos.size(); i++) {
////            cat.add(CartEntityInDto(dtos.get(i)));
////        }
//        return cat;
//    }
}
