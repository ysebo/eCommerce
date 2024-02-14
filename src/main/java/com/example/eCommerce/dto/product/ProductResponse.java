package com.example.eCommerce.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private Integer price;
    private String description;
    private String SKU;
}
