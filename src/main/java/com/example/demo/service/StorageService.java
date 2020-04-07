package com.example.demo.service;

import com.example.demo.dto.StorageDto;
import com.example.demo.entity.Storage;
import com.example.demo.repo.StorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StorageService {
    @Value("${upload.path}")
    private String path;

    @Autowired
    private StorageRepo repo;


    public Boolean create(StorageDto dto, MultipartFile file) throws IOException {
        Storage sl = new Storage();
        try {
            if (file != null){
                File uploadDir = new File(path);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                String uuidFile = UUID.randomUUID().toString();
                String resultFileName = uuidFile + "." + file.getOriginalFilename();
                file.transferTo(new File(uploadDir + "/" + resultFileName));
                sl.setFilename(resultFileName);
                sl.setUseless(dto.getUseless());
            }
            repo.save(sl);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean update(StorageDto dto, MultipartFile file) {
        Storage sl = repo.getOne(dto.getId());
        try {
            if (file != null){
                File uploadDir = new File(path);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                File oldFile = new File(uploadDir + "/" + sl.getFilename());
                oldFile.delete();
                String uuidFile = UUID.randomUUID().toString();
                String resultFileName = uuidFile + "." + file.getOriginalFilename();
                file.transferTo(new File(uploadDir + "/" + resultFileName));
                sl.setFilename(resultFileName);
                sl.setUseless(dto.getUseless());
                sl.setId(dto.getId());
            }
            repo.save(sl);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean delete(UUID id) {
        try{
            Storage sl = repo.getOne(id);
            repo.delete(sl);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public StorageDto get(UUID uuid) throws Exception {
        try {
            Storage sl = repo.getOne(uuid);
            StorageDto dto = new StorageDto();
            dto.setId(sl.getId());
            dto.setFilename(sl.getFilename());
            dto.setUseless(sl.getUseless());
            return dto;
        } catch (Exception e) {
            throw new Exception("Error");
        }
    }

    public List<StorageDto> getAll() throws Exception {
        try {
            List<StorageDto> dtos = new ArrayList<>();

            List<Storage> st = repo.findAll();
            for (int i = 0; i < st.size(); i++) {
                Storage sl = st.get(i);
                StorageDto dto = new StorageDto();
                dto.setId(sl.getId());
                dto.setFilename(sl.getFilename());
                dto.setUseless(sl.getUseless());
                dtos.add(dto);
            }
            return dtos;
        } catch (Exception e) {
            throw new Exception("Error");
        }
    }
}
