package com.example.eCommerce.mapper;

import com.example.eCommerce.dto.FavoriteResponse;
import com.example.eCommerce.dto.product.ProductResponse;
import com.example.eCommerce.entities.Favorite;
import com.example.eCommerce.entities.Product;

import java.util.List;

public interface FavoriteMapper {
    FavoriteResponse toDto(Favorite favorite);
    List<FavoriteResponse> toDtos(List<Favorite> all);
}
