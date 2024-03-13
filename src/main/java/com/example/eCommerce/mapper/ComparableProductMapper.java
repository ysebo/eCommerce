package com.example.eCommerce.mapper;

import com.example.eCommerce.dto.product.ProductComparisonResponse;
import com.example.eCommerce.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ComparableProductMapper {
    List<ProductComparisonResponse> toDto(Product product, Product product1);

}
