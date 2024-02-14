package com.example.eCommerce.mapper.impl;

import com.example.eCommerce.dto.product.ProductResponse;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductResponse toDto(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setId(product.getId());
        productResponse.setSKU(product.getSKU());
        return productResponse;
    }

    @Override
    public List<ProductResponse> toDtos(List<Product> all) {
        List<ProductResponse> products = new ArrayList<>();
        for(Product product: all){
            products.add(toDto(product));
        }
        return products;
    }
}
