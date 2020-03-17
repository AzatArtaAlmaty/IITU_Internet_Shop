package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.ItemEntity;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.mapper.itemMapper;
import com.example.demo.repo.CategoryRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    private final Logger logger = LoggerFactory.getLogger(CategoryService.class);
    @Transactional
    public List<CategoryDto> getCategoryList(Boolean all){
        List<Category> sample1 = categoryRepo.findAll();
        List<CategoryDto> dtos = CategoryMapper.ListCatEntityInDto(sample1, all);
        return dtos;
    }

    @Transactional()
    public UUID create(CategoryDto dto){
        Category sample = CategoryMapper.CatDtoInEntity(dto);
        return categoryRepo.save(sample).getId();
    }

    @Transactional(readOnly = true)
    public CategoryDto getInfo(UUID id, Boolean all){
        Category sample = categoryRepo.findById(id).get();
        CategoryDto dto = CategoryMapper.CatEntityInDto(sample, all);
        return dto;

    }

    public CategoryDto getInfoByName(String name, Boolean all){
        Category sample = categoryRepo.findByName(name);
        CategoryDto dto = CategoryMapper.CatEntityInDto(sample, all);
        return dto;

    }

}
