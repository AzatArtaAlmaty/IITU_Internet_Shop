package com.example.demo.service;


import com.example.demo.dto.ItemDto;
import com.example.demo.entity.ItemEntity;
import com.example.demo.mapper.itemMapper;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Value("${upload.path}")
    private String path;

    @Transactional
    public List<ItemDto> getItemList(){
        List<ItemEntity> items = itemRepo.findAll();
        List<ItemDto> dtos = itemMapper.ListEntityInDto(items);
        return dtos;
    }

    @Transactional
    public ItemDto getItem(UUID id) {
        ItemEntity item = itemRepo.findById(id).get();
        ItemDto sample = itemMapper.EntityInDto(item);
        return sample;
    }
    @Transactional
    public UUID createItem(ItemDto dto, MultipartFile file) throws IOException {

        ItemEntity item = itemMapper.DtoInEntity(dto, categoryRepo.getOne(dto.getCategory()));
        System.out.println(path);
        if (file != null){
            File uploadDir = new File(path);
            System.out.println(!uploadDir.exists());
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadDir + "/" + resultFileName));
            item.setFilename(resultFileName);
        }
        ItemEntity sample = itemRepo.save(item);
        return sample.getId();
    }

    @Transactional
    public void updateItem(ItemDto dto, MultipartFile file) throws IOException {
        ItemEntity item = itemRepo.findById(dto.getId()).get();
        if (file != null) {
            File uploadDir = new File(path);
            System.out.println(!uploadDir.exists());
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            File oldFile = new File(uploadDir + "/" + item.getFilename());
            oldFile.delete();
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadDir + "/" + resultFileName));
            item.setFilename(resultFileName);
        }
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setInfo(dto.getInfo());
        item.setCount(dto.getCount());
        item.setCategory(categoryRepo.getOne(dto.getCategory()));
        itemRepo.save(item);
    }

    @Transactional
    public void deleteItem(UUID id){
        File uploadDir = new File(path);
        new File(uploadDir + "/" + itemRepo.getOne(id).getFilename()).delete();
        itemRepo.deleteById(id);
    }

    @Transactional
    public List<ItemDto> search(String CatID, Integer before, Integer after){
        System.out.println(CatID);
        if (CatID != null)
            if (!CatID.equals("undefined") && before != null && after != null && !CatID.equals(""))
                return itemMapper.ListEntityInDto(itemRepo.findByCategoryAndPriceBetween(categoryRepo.getOne(UUID.fromString(CatID)), before, after));
            else if (!CatID.equals("undefined"))
                return itemMapper.ListEntityInDto(itemRepo.findByCategory(categoryRepo.getOne(UUID.fromString(CatID))));
            else if (before != null && after != null)
                return itemMapper.ListEntityInDto(itemRepo.findByPriceBetween(before, after));
            else
                return itemMapper.ListEntityInDto(itemRepo.findAll());
        else
            return itemMapper.ListEntityInDto(itemRepo.findAll());
    }

}
