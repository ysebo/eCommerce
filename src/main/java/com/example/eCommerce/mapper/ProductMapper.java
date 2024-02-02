package com.example.eCommerce.mapper;

import com.example.eCommerce.dto.Product.ProductResponse;
import com.example.eCommerce.entities.Product;

public interface ProductMapper {
    ProductResponse toDto(Product product);
}
