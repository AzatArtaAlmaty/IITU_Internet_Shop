package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.ItemEntity;
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

    Logger logger = LoggerFactory.getLogger(CategoryService.class);
    @Transactional
    public List<CategoryDto> getCategoryList(){
        List<Category> sample1 = categoryRepo.findAll();
        List<CategoryDto> dtos = new ArrayList<>();
        for (int i = 0; i < sample1.size(); i++){
            Category each = sample1.get(i);
            CategoryDto dto = new CategoryDto();
            dto.setId(each.getId());
            dto.setName(each.getName());
            dto.setImage(each.getImage());
            List<ItemDto> itemDtoList = new ArrayList<>();
            for (int j =0; j < each.getItems().size(); j++) {
                ItemDto dto1 = new ItemDto();
                ItemEntity itemEntity = each.getItems().get(j);
                dto1.setId(itemEntity.getId());
                dto1.setCount(itemEntity.getCount());
                dto1.setInfo(itemEntity.getInfo());
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setName(itemEntity.getCategory().getName());
                categoryDto.setId(itemEntity.getCategory().getId());
                dto1.setCategory(categoryDto);
                dto1.setName(itemEntity.getName());
                dto1.setPrice(itemEntity.getPrice());
//                dto1.setImage(itemEntity.getImage());
                itemDtoList.add(dto1);
            }
            dto.setItems(itemDtoList);
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional()
    public UUID create(CategoryDto dto){
        Category sample = new Category();
        sample.setName(dto.getName());
        logger.info(String.valueOf(dto.getImage()));
        sample.setImage(dto.getImage());
        Category sample1 = categoryRepo.save(sample);
        return sample1.getId();
    }

    @Transactional(readOnly = true)
    public CategoryDto getInfo(UUID id){
        Category sample = categoryRepo.findById(id).get();
        CategoryDto dto = new CategoryDto();
        dto.setId(sample.getId());
        dto.setName(sample.getName());
        dto.setImage(sample.getImage());
        List<ItemDto> itemDtoList = new ArrayList<>();
        for (int j =0; j < sample.getItems().size(); j++) {
            ItemDto dto1 = new ItemDto();
            ItemEntity itemEntity = sample.getItems().get(j);
            dto1.setId(itemEntity.getId());
            dto1.setCount(itemEntity.getCount());
            dto1.setInfo(itemEntity.getInfo());
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(itemEntity.getCategory().getName());
            categoryDto.setId(itemEntity.getCategory().getId());
            dto1.setCategory(categoryDto);
            dto1.setName(itemEntity.getName());
            dto1.setPrice(itemEntity.getPrice());
//            dto1.setImage(itemEntity.getImage());
            itemDtoList.add(dto1);
        }
        dto.setItems(itemDtoList);
        return dto;

    }

    public CategoryDto getInfoByName(String name){
        Category sample = categoryRepo.findByName(name);
        CategoryDto dto = new CategoryDto();
        dto.setId(sample.getId());
        dto.setName(sample.getName());
        return dto;

    }

    public String categoryImage(UUID id, MultipartFile image) throws IOException {
        Category sample = categoryRepo.findById(id).get();
        sample.setImage(image.getBytes());
        categoryRepo.save(sample);
        return "Success";
    }
}
