package com.example.demo.dto;


import com.example.demo.entity.Useless;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StorageDto {
    private UUID id;
    private String filename;
    private Useless useless;
}
