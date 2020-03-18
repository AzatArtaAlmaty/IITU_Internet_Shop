package com.example.demo.RestController;

import com.example.demo.dto.CartDto;
import com.example.demo.entity.CartEntity;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartRestController {
    @Autowired
    CartService service;


    @PostMapping("/create")
    public void createCart(@RequestBody CartDto dto) {
        service.create(dto);
    }

    @GetMapping("/get")
    public CartDto getCart(@RequestParam UUID id) {
        return service.get(id);
    }

    @GetMapping("/getAll")
    public List<CartDto> getAllCart() {
        return service.getAll();
    }
}
