package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.ItemEntity;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.mapper.itemMapper;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.repo.ItemRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ItemRepo itemRepo;


    @Value("${upload.path}")
    private String path;

    private final Logger logger = LoggerFactory.getLogger(CategoryService.class);
    @Transactional
    public List<CategoryDto> getCategoryList(){
        List<Category> sample1 = categoryRepo.findAll();
        List<CategoryDto> dtos = CategoryMapper.ListCatEntityInDto(sample1);
        return dtos;
    }

    @Transactional()
    public UUID create(CategoryDto dto, MultipartFile file) throws IOException {
        Category sample = CategoryMapper.CatDtoInEntity(dto);
        if (file != null){
            File uploadDir = new File(path);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadDir + "/" + resultFileName));
            sample.setFilename(resultFileName);
        }
        return categoryRepo.save(sample).getId();
    }

    @Transactional()
    public UUID update(CategoryDto dto, MultipartFile file) throws IOException {

        Category sample = categoryRepo.getOne(dto.getId());
        sample.setName(dto.getName());
        if (file != null){
            File uploadDir = new File(path);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            File oldFile = new File(uploadDir + "/" + sample.getFilename());
            oldFile.delete();
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadDir + "/" + resultFileName));
            sample.setFilename(resultFileName);
        }
        return categoryRepo.save(sample).getId();
    }

    @Transactional(readOnly = true)
    public CategoryDto getInfo(UUID id){
        Category sample = categoryRepo.findById(id).get();
        CategoryDto dto = CategoryMapper.CatEntityInDto(sample);
        return dto;

    }

    public CategoryDto getInfoByName(String name){
        Category sample = categoryRepo.findByName(name);
        CategoryDto dto = CategoryMapper.CatEntityInDto(sample);
        return dto;

    }

    public void delete(UUID id) {
        File uploadDir = new File(path);
        new File(uploadDir + "/" + categoryRepo.getOne(id).getFilename()).delete();
        categoryRepo.deleteById(id);
    }

    public List<ItemDto> findItemByCategory(UUID id) {
        List<ItemDto> sample = itemMapper.ListEntityInDto(itemRepo.findByCategory(categoryRepo.getOne(id)));
        return sample;
    }
}
