package com.example.eCommerce.controller;

import com.example.eCommerce.dto.favorite.FavoriteResponse;
import com.example.eCommerce.dto.product.ProductResponse;
import com.example.eCommerce.service.favorite.FavoriteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/favorite")
public class FavoriteController {
    private final FavoriteService favoriteService;
    @PostMapping("/add/{productId}")
    public String addProductToFav(@PathVariable Long productId, @RequestHeader("Authorization-Bearer") String token){
        favoriteService.addToFav(productId, token);
        return " product added to favorite";
    }

    @DeleteMapping("/deleteFav/{productId}")
    public void deleteFav(@PathVariable Long productId, @RequestHeader ("Authorization-Bearer") String token){
        favoriteService.deleteFav(productId, token);
    }

    @GetMapping("/get")
    public List<ProductResponse> getFav(@RequestHeader("Authorization-Bearer") String token){
        return favoriteService.getFav( token);
    }
}
