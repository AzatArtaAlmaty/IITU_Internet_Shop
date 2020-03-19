package com.example.demo.RestController;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ItemDto;
import com.example.demo.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public CategoryDto getInfo(@RequestParam UUID id){
        return categoryService.getInfo(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EDITOR')")
    @PostMapping("/create")
    public UUID create(@RequestParam("body") String str, @RequestParam("file") MultipartFile file) throws IOException {
        CategoryDto dto = new ObjectMapper().readValue(str, CategoryDto.class);
        return categoryService.create(dto, file);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EDITOR')")
    @PostMapping("/update")
    public UUID update(@RequestParam("body") String str, @RequestParam("file") MultipartFile file) throws IOException {
        CategoryDto dto = new ObjectMapper().readValue(str, CategoryDto.class);
        return categoryService.update(dto, file);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EDITOR')")
    @GetMapping("/delete")
    public void delete(@RequestParam UUID id) {
        categoryService.delete(id);
    }

    @GetMapping("/findItemByCategory")
    public List<ItemDto> findItemByCategory(@RequestParam UUID id) {
        return categoryService.findItemByCategory(id);
    }
}
