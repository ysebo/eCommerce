package com.example.eCommerce.service.favorite;

import com.example.eCommerce.dto.FavoriteResponse;

import java.util.List;

public interface FavoriteService {
    void addToFav(Long productId, String token);

    void deleteFav(Long productId, String token);

    FavoriteResponse getFav(Long favoriteId, String token);

    List<FavoriteResponse> getUsersFav(String token);
}
