package com.example.eCommerce.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductComparisonResponse {
    private String Sales_Package;
    private String Color;
    private String MaximumLoadCapacity;
    private String OriginOfManufacture;
    private String width;
    private String height ;
    private String weight;
    private Integer price;
}
