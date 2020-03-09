package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "category", orphanRemoval = true)
    private List<ItemEntity> items;

    @Lob
    private byte[] image;
}
