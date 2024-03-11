package com.example.eCommerce.controller;

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
    public String addProductToFav(@PathVariable Long productId, @RequestHeader("Authorization") String token){
        favoriteService.addToFav(productId, token);
        return "Product was added to favorites";
    }

    @DeleteMapping("/deleteFav/{productId}")
    public void deleteFromFav(@PathVariable Long productId, @RequestHeader ("Authorization") String token){
        favoriteService.deleteFav(productId, token);
    }

    @GetMapping("/get")
    public List<ProductResponse> getFav(@RequestHeader("Authorization") String token){
        return favoriteService.getFav(token);
    }

}
