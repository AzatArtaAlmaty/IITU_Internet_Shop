package com.example.demo.mapper;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Category;

public class CategoryMapper {
    public static Category CatDtoInEntity(CategoryDto dto) {
        Category cat = new Category();
        cat.setName(dto.getName());
        return cat;
    }

    public static CategoryDto CatEntityInDto(Category dto) {
        CategoryDto cat = new CategoryDto();
        cat.setId(dto.getId());
        cat.setName(dto.getName());
        return cat;
    }
}
