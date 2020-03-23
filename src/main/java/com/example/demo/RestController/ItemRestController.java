package com.example.demo.RestController;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.ItemEntity;
import com.example.demo.service.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/item")
public class ItemRestController {
    @Autowired
    private ItemService itemService;

    @PreAuthorize("permitAll()")
    @GetMapping("/getList")
    public List<ItemDto> getItemList(){
        return itemService.getItemList();
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/get")
    public ItemDto getItem(@RequestParam UUID id){
        return itemService.getItem(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EDITOR')")
    @PostMapping("/create")
    public UUID createItem(@RequestParam("body") String str, @RequestParam("file") MultipartFile file) throws IOException {
//        System.out.println(file.isEmpty());
        ItemDto dto = new ObjectMapper().readValue(str, ItemDto.class);
        return itemService.createItem(dto, file);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EDITOR')")
    @PostMapping("/update")
    public void updateItem(@RequestParam("body") String str, @RequestParam("file") MultipartFile file) throws IOException {
        ItemDto dto = new ObjectMapper().readValue(str, ItemDto.class);
        itemService.updateItem(dto, file);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EDITOR')")
    @GetMapping("/delete")
    public void deleteItem(@RequestParam UUID id){
        itemService.deleteItem(id);
    }

    @GetMapping("/search")
    public List<ItemDto> search(@RequestParam(required = false) String cat, @RequestParam(required = false) String before, @RequestParam(required = false) String after){
        try{
            return  itemService.search(cat, Integer.parseInt(before), Integer.parseInt(after));
        } catch (Exception e){
            return  itemService.search(cat, null, null);
        }
    }
}
