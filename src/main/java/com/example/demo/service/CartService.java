package com.example.demo.service;

import com.example.demo.dto.CartDto;
import com.example.demo.entity.CartEntity;
import com.example.demo.entity.CartItems;
import com.example.demo.repo.CartItemRepo;
import com.example.demo.repo.CartRepo;
import com.example.demo.repo.ItemRepo;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
        CartEntity cart = new CartEntity();
        cart.setCost(dto.getCost());
        cart.setUser(userRepo.getOne(dto.getId()));
        cart = cartRepo.save(cart);
        List<CartItems> items = new ArrayList<>();
        for (int i = 0; i < dto.getItems().size(); i++) {
            CartItems sample = new CartItems();
            sample.setItem(itemRepo.getOne(dto.getItems().get(i)));
            sample.setCart(cart);
            cartItemRepo.save(sample);
            items.add(sample);
        }
        cart.setItems(items);
        cartRepo.save(cart);
    }
}
