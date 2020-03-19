package com.example.demo.repo;

import com.example.demo.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CartItemRepo extends JpaRepository<CartItems, Serializable> {
}
