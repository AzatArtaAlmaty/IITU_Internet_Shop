package com.example.demo.mapper;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.ItemEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class itemMapper {


    public static ItemEntity DtoInEntity(ItemDto dto, Category cat) {
        ItemEntity sample = new ItemEntity();
        sample.setName(dto.getName());
        sample.setPrice(dto.getPrice());
        sample.setInfo(dto.getInfo());
        sample.setCount(dto.getCount());
        sample.setCategory(cat);
        return sample;
    }

    public static ItemDto EntityInDto(ItemEntity dto) {
        ItemDto sample = new ItemDto();
        sample.setId(dto.getId());
        sample.setName(dto.getName());
        sample.setPrice(dto.getPrice());
        sample.setInfo(dto.getInfo());
        sample.setCount(dto.getCount());
        sample.setCategory(dto.getCategory().getId());
//        if (all) {
//            List<UUID> ids = new ArrayList<>();
//            for (int i = 0; i < dto.getCart().size(); i++) {
//                ids.add(dto.getCart().get(i).getId());
//            }
//            sample.setCart(ids);
//        }
        return sample;
    }

    public static List<ItemDto> ListEntityInDto(List<ItemEntity> dtos) {
        List<ItemDto> items = new ArrayList<>();
        for (int i = 0; i < dtos.size(); i++) {
            items.add(EntityInDto(dtos.get(i)));
        }
        return items;
    }
}
