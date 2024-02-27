package com.example.eCommerce.dto.product;

import lombok.Getter;
import lombok.Setter;

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

    private String originOfManufacture;
    private String width;
    private String height ;
    private String weight;
    private String warranty_summary;

}
