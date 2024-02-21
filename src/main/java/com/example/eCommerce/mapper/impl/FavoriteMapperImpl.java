package com.example.eCommerce.mapper.impl;

import com.example.eCommerce.dto.FavoriteResponse;
import com.example.eCommerce.entities.Favorite;
import com.example.eCommerce.mapper.FavoriteMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FavoriteMapperImpl implements FavoriteMapper {
    @Override
    public FavoriteResponse toDto(Favorite favorite) {
        FavoriteResponse favoriteResponse = new FavoriteResponse();
        favoriteResponse.setId(favorite.getId());
        favoriteResponse.setUser(favorite.getUser());
        favoriteResponse.setProduct(favorite.getProduct());
        return favoriteResponse;
    }

    @Override
    public List<FavoriteResponse> toDtos(List<Favorite> all) {
        List<FavoriteResponse> favorites = new ArrayList<>();
        for(Favorite favorite: all){
            favorites.add(toDto(favorite));
        }
        return favorites;
    }
}
