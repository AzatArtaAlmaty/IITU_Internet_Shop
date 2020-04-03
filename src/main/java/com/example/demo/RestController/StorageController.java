package com.example.demo.RestController;

import com.example.demo.dto.StorageDto;
import com.example.demo.service.StorageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/storage")
public class StorageController {
    @Autowired
    private StorageService service;

    @GetMapping("/get")
    public StorageDto get(@RequestParam UUID id) throws Exception{
        return service.get(id);
    }

    @GetMapping("/getAll")
    public List<StorageDto> getAll() throws Exception{
        return service.getAll();
    }

    @PostMapping("/create")
    public Boolean create(@RequestParam("body") String str, @RequestParam("file") MultipartFile file) throws Exception {
        StorageDto dto = new ObjectMapper().readValue(str, StorageDto.class);
        return service.create(dto, file);
    }

    @PostMapping("/update")
    public Boolean update(@RequestParam("body") String str, @RequestParam("file") MultipartFile file) throws Exception {
        StorageDto dto = new ObjectMapper().readValue(str, StorageDto.class);
        return service.update(dto, file);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestParam() UUID id) throws Exception {
        return service.delete(id);
    }
}
