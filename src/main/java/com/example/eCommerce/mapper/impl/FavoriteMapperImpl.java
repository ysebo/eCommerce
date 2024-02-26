package com.example.eCommerce.mapper.impl;

import com.example.eCommerce.dto.favorite.FavoriteResponse;
import com.example.eCommerce.dto.product.ProductResponse;
import com.example.eCommerce.entities.Favorite;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.mapper.FavoriteMapper;
import com.example.eCommerce.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FavoriteMapperImpl implements FavoriteMapper {
    @Override
    public ProductResponse toDto(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setSKU(product.getSKU());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }

    @Override
    public List<ProductResponse> toDtos(List<Product> all) {
        List<ProductResponse> favorites = new ArrayList<>();
        for(Product product: all){
            favorites.add(toDto(product));
        }
        return favorites;
    }
}
