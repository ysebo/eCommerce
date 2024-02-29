package com.example.eCommerce.dto.product;

import com.example.eCommerce.enums.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private Integer price;
    private String description;
    private String sales_Package;
    private String color;
    private String secondaryMaterial;
    private String configuration;
    private List<Tag> tags;
    private String originOfManufacture;
    private String width;
    private String height ;
    private String weight;
    private String warranty_summary;
    private String category;

}
