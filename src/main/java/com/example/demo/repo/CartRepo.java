package com.example.demo.repo;

import com.example.demo.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CartRepo extends JpaRepository<CartEntity, Serializable> {
}
