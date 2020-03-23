package com.example.demo.repo;

import com.example.demo.entity.Category;
import com.example.demo.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<ItemEntity, Serializable> {
    public List<ItemEntity> findByCategory(Category cat);
    public List<ItemEntity> findByCategoryAndPriceBetween(Category cat, Integer before, Integer after);
    public List<ItemEntity> findByPriceBetween(Integer before, Integer after);
}
