package com.example.demo.mapper;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategoryMapper {
    public static Category CatDtoInEntity(CategoryDto dto) {
        Category cat = new Category();
        cat.setName(dto.getName());
        return cat;
    }

    public static CategoryDto CatEntityInDto(Category dto, Boolean all) {
        CategoryDto cat = new CategoryDto();
        cat.setId(dto.getId());
        cat.setName(dto.getName());
        if (all){
            List<UUID> items = new ArrayList<>();
            for (int i = 0; i < dto.getItems().size(); i++) {
                Category each = new Category();
                items.add(each.getId());
            }
            cat.setItems(items);
        }
        return cat;
    }

    public static List<CategoryDto> ListCatEntityInDto(List<Category> dtos, Boolean all) {
        List<CategoryDto> cat = new ArrayList<>();
        for (int i = 0; i < dtos.size(); i++) {
            cat.add(CatEntityInDto(dtos.get(i), all));
        }
        return cat;
    }
}
