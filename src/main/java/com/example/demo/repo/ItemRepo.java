package com.example.demo.repo;

import com.example.demo.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ItemRepo extends JpaRepository<ItemEntity, Serializable> {
}
