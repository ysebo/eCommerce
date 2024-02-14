package com.example.eCommerce.mapper;

import com.example.eCommerce.dto.product.ProductComparisonResponse;
import com.example.eCommerce.entities.Product;

import java.util.Optional;

public interface ComparableProductMapper {
    ProductComparisonResponse toDto(Product product);
}
