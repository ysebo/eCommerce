package com.example.eCommerce.controller;

import com.example.eCommerce.dto.FavoriteResponse;
import com.example.eCommerce.service.favorite.FavoriteService;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
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
        return "added product to favorite";
    }

    @DeleteMapping("/deleteFav/{productId}")
    public void deleteFav(@PathVariable Long productId, @RequestHeader ("Authorization-Bearer") String token){
        favoriteService.deleteFav(productId, token);
    }

    @GetMapping("/get/{favoriteId}")
    public FavoriteResponse getFav(@PathVariable Long favoriteId, @RequestHeader("Authorization-Bearer") String token){
        return favoriteService.getFav(favoriteId, token);
    }

    @GetMapping("/getUsersFav")
    public List<FavoriteResponse> getUsersFav(@RequestHeader ("Authorization-Bearer") String token){
        return favoriteService.getUsersFav(token);
    }
}
