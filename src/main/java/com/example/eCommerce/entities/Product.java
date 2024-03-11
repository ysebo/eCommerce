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
    private Integer quantity;
    private Boolean exist;
    private String secondaryMaterial;
    private String configuration;
    private String originOfManufacture;
    private String width;
    private String height ;
    private String weight;
    private String warranty_summary;


    private String SKU = UUID.randomUUID().toString().substring(0, 13);
    @ElementCollection(targetClass = Tag.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "product_tags", joinColumns = @JoinColumn(name = "product_id"))
    @Enumerated(EnumType.STRING)
    private List<Tag> tags;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews;


    @ManyToOne
    private Favorite favorite;
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private OrderHistory orderHistory;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Image>images;











}
