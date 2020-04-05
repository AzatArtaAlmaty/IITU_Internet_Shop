package com.example.demo.mapper;

import com.example.demo.dto.CartItemsDto;
import com.example.demo.entity.CartEntity;
import com.example.demo.entity.CartItems;
import com.example.demo.entity.ItemEntity;

import java.util.ArrayList;
import java.util.List;

public class CartItemsMapper {
    public static CartItems DtoInEntity(CartItemsDto dto, CartEntity cart, ItemEntity item) {
        CartItems ent = new CartItems();
        ent.setCount(dto.getCount());
        ent.setCart(cart);
        ent.setItem(item);
        return ent;
    }

    public static CartItemsDto EntityToDto(CartItems ent) {
        CartItemsDto dto = new CartItemsDto();
        dto.setId(ent.getId());
        dto.setCart(ent.getCart().getId());
        dto.setItem(ent.getItem().getId());
        dto.setCount(ent.getCount());
        return dto;
    }

    public static List<CartItemsDto> ListEntityToDto(List<CartItems> ents) {
        List<CartItemsDto> dto = new ArrayList<>();
        for (int i = 0; i < ents.size(); i++) {
            CartItems ent = ents.get(i);
            CartItemsDto cartItemsDto = EntityToDto(ent);
            dto.add(cartItemsDto);
        }
        return dto;
    }

//    public static List<CartItems> ListDtoToEntity(List<CartItemsDto> ents) {
//        List<CartItems> dto = new ArrayList<>();
//        for (int i = 0; i < ents.size(); i++) {
//            CartItemsDto ent = ents.get(i);
//            CartItemsDto cartItemsDto = DtoInEntity(ent, ent.getCart());
//            dto.add(cartItemsDto);
//        }
//        return dto;
//    }
}
