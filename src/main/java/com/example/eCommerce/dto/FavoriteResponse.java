package com.example.eCommerce.dto;

import com.example.eCommerce.entities.Product;
import com.example.eCommerce.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoriteResponse {
    private Long id;
    private Product product;
    private User user;


}
