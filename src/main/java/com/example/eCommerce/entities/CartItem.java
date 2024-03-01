package com.example.eCommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "cart_item_table")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String SKU;
    private Integer quantity;
    private Integer price;
    private Integer subtotal;
    private Integer total;
    @ManyToOne
    private Cart cart;
}
