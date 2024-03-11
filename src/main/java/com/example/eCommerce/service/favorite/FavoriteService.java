package com.example.eCommerce.service.favorite;

import com.example.eCommerce.dto.cart.CartRequest;
import com.example.eCommerce.dto.favorite.FavoriteResponse;
import com.example.eCommerce.dto.product.ProductResponse;

import java.util.List;

public interface FavoriteService {
    void addToFav(Long productId, String token);

    void deleteFav(Long productId, String token);

    List<ProductResponse> getFav(String token);


}
