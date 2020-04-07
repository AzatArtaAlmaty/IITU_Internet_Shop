package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cart")
@Data
public class CartEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    private Integer cost;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String city;
    private String region;
    private String postIndex;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private List<CartItems> items;
}
