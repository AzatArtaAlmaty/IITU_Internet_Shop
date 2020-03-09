package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Data
public class CartItems {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @ManyToOne
    private CartEntity cart;

    @ManyToOne
    private ItemEntity item;
}
