package com.example.demo.service;

import com.example.demo.dto.CartDto;
import com.example.demo.entity.CartEntity;
import com.example.demo.entity.CartItems;
import com.example.demo.mapper.CartItemsMapper;
import com.example.demo.mapper.CartMapper;
import com.example.demo.repo.CartItemRepo;
import com.example.demo.repo.CartRepo;
import com.example.demo.repo.ItemRepo;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    CartItemRepo cartItemRepo;

    @Transactional(readOnly = false)
    public void create(CartDto dto){
        CartEntity cart = CartMapper.CartDtoInEntity(dto); //userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
        cart = cartRepo.save(cart);
        for(int i = 0; i < dto.getItems().size(); i++){
            CartItems cartItems = CartItemsMapper.DtoInEntity(dto.getItems().get(i), cart, itemRepo.getOne(dto.getItems().get(i).getItem()));
            cartItemRepo.save(cartItems);
        }
    }

    @Transactional(readOnly = false)
    public CartDto get(UUID id) {
        CartEntity sample = cartRepo.getOne(id);
        CartDto dto = CartMapper.CartEntityInDto(sample);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<CartDto> getAll(){
        List<CartEntity> sample = cartRepo.findAll();
        List<CartDto> dtos = new ArrayList<>();
        for (int i = 0; i < sample.size(); i++) {
            CartDto ent = CartMapper.CartEntityInDto(sample.get(i));
            dtos.add(ent);
        }
        return dtos;
    }
}
