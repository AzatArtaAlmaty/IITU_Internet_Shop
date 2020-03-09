package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
public class CartEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(nullable = false)
    private Integer cost;

    @OneToMany(mappedBy = "cart")
    private List<CartItems> items;

    @ManyToOne
    private UserEntity user;
}
