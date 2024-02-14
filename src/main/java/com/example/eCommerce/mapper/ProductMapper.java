package com.example.eCommerce.mapper;

import com.example.eCommerce.dto.product.ProductResponse;
import com.example.eCommerce.entities.Product;

import java.util.List;

public interface ProductMapper {
    ProductResponse toDto(Product product);
    List<ProductResponse> toDtos(List<Product> all);
}
