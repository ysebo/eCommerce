package com.example.eCommerce.mapper.Impl;

import com.example.eCommerce.dto.Product.ProductResponse;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.mapper.ProductMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductResponse toDto(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setId(product.getId());
        productResponse.setUnicode(product.getUnicode());
        return productResponse;
    }
}
