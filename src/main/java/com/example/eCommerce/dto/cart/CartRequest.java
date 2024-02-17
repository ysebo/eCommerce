package com.example.eCommerce.dto.cart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CartRequest {
    private Long productId;
    private String SKU;
    private Integer quantity;
    private Integer price;
}
