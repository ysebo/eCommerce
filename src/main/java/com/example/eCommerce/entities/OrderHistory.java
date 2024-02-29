package com.example.eCommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "order_history_table")
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private LocalDate date;
    private String firstname;
    private String additionalInfo;
    private String email;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cart cart;
    @OneToMany
    private List<Product> products;
    @ManyToOne(cascade =CascadeType.ALL )
    private User user;

}
