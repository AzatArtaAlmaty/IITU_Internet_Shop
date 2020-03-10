package com.example.demo.mapper;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.ItemEntity;

public class itemMapper {


    public static ItemEntity DtoInEntity(ItemDto dto) {
        ItemEntity sample = new ItemEntity();
        sample.setName(dto.getName());
        sample.setPrice(dto.getPrice());
        sample.setInfo(dto.getInfo());
        sample.setCount(dto.getCount());
        return sample;
    }

    public static ItemDto EntityInDto(ItemEntity dto) {
        ItemDto sample = new ItemDto();
        sample.setId(dto.getId());
        sample.setName(dto.getName());
        sample.setPrice(dto.getPrice());
        sample.setInfo(dto.getInfo());
        sample.setCount(dto.getCount());
        return sample;
    }
}
