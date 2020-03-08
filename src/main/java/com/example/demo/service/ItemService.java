package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ItemDto;
import com.example.demo.entity.ItemEntity;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Transactional
    public List<ItemDto> getItemList(){
        List<ItemEntity> items = itemRepo.findAll();
        List<ItemDto> dtos = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            ItemEntity item = items.get(i);
            ItemDto sample = new ItemDto();
            sample.setId(item.getId());
            sample.setCount(item.getCount());
            sample.setInfo(item.getInfo());
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(item.getCategory().getName());
            categoryDto.setId(item.getCategory().getId());
            sample.setCategory(categoryDto);
            sample.setName(item.getName());
            sample.setPrice(item.getPrice());
            dtos.add(sample);
        }
        return dtos;
    }

    @Transactional
    public ItemDto getItem(UUID id){
        ItemEntity item = itemRepo.findById(id).get();
        ItemDto sample = new ItemDto();
        sample.setId(item.getId());
        sample.setCount(item.getCount());
        sample.setInfo(item.getInfo());
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(item.getCategory().getName());
        categoryDto.setId(item.getCategory().getId());
        sample.setCategory(categoryDto);
        sample.setName(item.getName());
        sample.setPrice(item.getPrice());

        return sample;
    }
    @Transactional
    public UUID createItem(ItemDto dto) {
        ItemEntity item = new ItemEntity();
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setInfo(dto.getInfo());
        item.setCount(dto.getCount());
        item.setCategory(categoryRepo.findByName(dto.getCategory().getName()));
        ItemEntity sample = itemRepo.save(item);
        return sample.getId();
    }

    @Transactional
    public String itemImage(UUID id, MultipartFile image) throws IOException {
        ItemEntity sample = itemRepo.findById(id).get();
        sample.setImage(image.getBytes());
        itemRepo.save(sample);
        return "Success";
    }

    @Transactional
    public void updateItem(ItemDto dto){
        ItemEntity item = itemRepo.findById(dto.getId()).get();
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setInfo(dto.getInfo());
        item.setCount(dto.getCount());
        item.setCategory(categoryRepo.findByName(dto.getCategory().getName()));
        itemRepo.save(item);
    }

    @Transactional
    public void deleteItem(UUID id){
        itemRepo.deleteById(id);
    }

}
