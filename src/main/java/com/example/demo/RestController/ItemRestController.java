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
    @PostMapping("/itemImage")
    public String itemImage(@RequestParam(value = "id") UUID id, @RequestPart(value = "image") MultipartFile image) throws IOException {
        return itemService.itemImage(id, image);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EDITOR')")
    @PostMapping("/update")
    public void updateItem(@RequestBody ItemDto dto){
        itemService.updateItem(dto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EDITOR')")
    @PostMapping("/delete")
    public void deleteItem(@RequestParam UUID id){
        itemService.deleteItem(id);
    }
}
