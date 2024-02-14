package com.example.eCommerce.entities;

import com.example.eCommerce.enums.Tag;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "product_table")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private String description;

    private String sales_Package;
    private String color;
    private String secondaryMaterial;
    private String configuration;
    private String fillingMaterial;
    private String originOfManufacture;
    private String width;
    private String height ;
    private String weight;
    private String warranty_summary;
    private String covered_in_warranty;
    private String notCoveredInWarranty;
    private String domesticWarranty;

    private String SKU = UUID.randomUUID().toString().substring(0, 13);
    @ElementCollection(targetClass = Tag.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "product_tags", joinColumns = @JoinColumn(name = "product_id"))
    @Enumerated(EnumType.STRING)
    private List<Tag> tags;









}
