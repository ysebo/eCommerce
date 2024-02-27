package com.example.eCommerce.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
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
}
