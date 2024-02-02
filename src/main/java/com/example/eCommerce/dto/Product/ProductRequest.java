package com.example.eCommerce.dto.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private Integer price;
    private String description;
}
