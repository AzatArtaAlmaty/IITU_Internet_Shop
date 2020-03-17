package com.example.demo.RestController;

import com.example.demo.dto.CartDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartRestController {
    @PostMapping("/create")
    public void createCart(@RequestBody CartDto dto) {
        return ;
    }
}
