package com.example.eCommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "images_table")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    @JoinColumn(name = "path")
    private String path;
    @OneToOne
    private Product product;
    @OneToMany
    private List<CartItem> items;

    @OneToMany
    private List<OrderHistory> orders;


}
