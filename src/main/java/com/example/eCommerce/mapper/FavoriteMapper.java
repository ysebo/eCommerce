package com.example.eCommerce.mapper;

import com.example.eCommerce.dto.favorite.FavoriteResponse;
import com.example.eCommerce.dto.product.ProductResponse;
import com.example.eCommerce.entities.Favorite;
import com.example.eCommerce.entities.Product;

import java.util.List;

public interface FavoriteMapper {
    ProductResponse toDto(Product product);
    List<ProductResponse> toDtos(List<Product> all);
}
