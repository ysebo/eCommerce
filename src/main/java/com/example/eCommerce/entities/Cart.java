package com.example.eCommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cart_table")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String SKU;
    private Integer quantity;
    private Integer price;
    @OneToOne
    private User user;
    @OneToMany
    private List<Product> products;


}
