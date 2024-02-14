package com.example.eCommerce.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductComparisonResponse {
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
    private Integer price;
}
