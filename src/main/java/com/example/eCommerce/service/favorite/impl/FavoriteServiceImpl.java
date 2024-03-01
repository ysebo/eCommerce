package com.example.eCommerce.service.favorite.impl;

import com.example.eCommerce.dto.cart.CartRequest;
import com.example.eCommerce.dto.favorite.FavoriteResponse;
import com.example.eCommerce.dto.product.ProductResponse;
import com.example.eCommerce.entities.Favorite;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.entities.User;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.mapper.FavoriteMapper;
import com.example.eCommerce.repositories.FavoriteRepository;
import com.example.eCommerce.repositories.ProductRepository;
import com.example.eCommerce.repositories.UserRepository;
import com.example.eCommerce.service.auth.AuthService;
import com.example.eCommerce.service.favorite.FavoriteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {
    private final ProductRepository productRepository;
    private final AuthService authService;
    private final FavoriteRepository favoriteRepository;
    private final FavoriteMapper favoriteMapper;

    private final UserRepository userRepository;

    @Override
    public void addToFav(Long productId, String token) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) {
            throw new NotFoundException("This product doesn't exist!", HttpStatus.NOT_FOUND);
        }
        User user = authService.getUsernameFromToken(token);
        List<Product> favoriteProducts = user.getFavorites();
        favoriteProducts.add(product.get());
        userRepository.save(user);


    }
    @Override
    public List<ProductResponse> getFav(String token) {
        User user = authService.getUsernameFromToken(token);
        List<Product> userFavorites  =  user.getFavorites();
        return favoriteMapper.toDtos(userFavorites);
    }

    @Override
    public void updateFav(Long productId, String token) {
        User user = authService.getUsernameFromToken(token);
        Optional<Product> product = productRepository.findById(productId);
        if(product.isEmpty()){
            throw new NotFoundException("This product doesn't exist , please choose another one! " , HttpStatus.NOT_FOUND);
        }
        List<Product> favoriteProducts = user.getFavorites();


    }


    @Override
    public void deleteFav(Long productId, String token) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isEmpty()) {
            throw new NotFoundException("This product doesn't exist!", HttpStatus.NOT_FOUND);
        }

        Product product = productOptional.get();

        User user = new User();
        user.getFavorites().remove(product);
        userRepository.save(user);
        productRepository.save(product);
    }
}
