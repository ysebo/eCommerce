package com.example.eCommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "payment_table")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String companyName;
    private String country;
    private String streetAddress;
    private String townName;
    private String provinceName;
    private Integer ZipCode;
    private Integer phone;
    private String email;
    private String additionalInfo;

}
