package com.example.demo.dto;

import com.example.demo.entity.CartItems;
import com.example.demo.entity.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
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
    private String filename;
    private Category category;
    private List<CartItems> cart;
}
