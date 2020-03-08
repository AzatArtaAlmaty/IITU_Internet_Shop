package com.example.demo.RestController;

import com.example.demo.dto.CategoryDto;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/all")
    public List<CategoryDto> getAll(){
        return categoryService.getCategoryList();
    }

    @GetMapping("/get")
    public CategoryDto geInfo(@RequestParam UUID id){
        return categoryService.getInfo(id);
    }

    @GetMapping("/getByName")
    public CategoryDto geInfoByName(@RequestParam String name){
        return categoryService.getInfoByName(name);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EDITOR')")
    @PostMapping("/create")
    public UUID create(@RequestBody CategoryDto dto){
        return categoryService.create(dto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EDITOR')")
    @PostMapping("/categoryImage")
    public String categoryImage(@RequestParam(value = "id") UUID id, @RequestPart(value = "image") MultipartFile image) throws IOException {
        return categoryService.categoryImage(id, image);
    }
}
