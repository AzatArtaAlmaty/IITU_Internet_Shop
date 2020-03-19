package com.example.demo.dto;

import com.example.demo.entity.ItemEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {
    private UUID id;
    private String name;
    private String filename;
}
