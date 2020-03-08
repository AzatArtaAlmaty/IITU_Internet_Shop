package com.example.demo.dto;

import com.example.demo.entity.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ItemDto {
    private UUID id;
    private Integer count;
    private String info;
    private String name;
    private Integer price;
    private CategoryDto category;
    private byte[] image;
}
