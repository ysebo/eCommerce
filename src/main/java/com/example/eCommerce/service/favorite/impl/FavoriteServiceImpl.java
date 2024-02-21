package com.example.eCommerce.service.favorite.impl;

import com.example.eCommerce.dto.FavoriteResponse;
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

import java.util.List;
import java.util.Optional;
import java.util.PrimitiveIterator;

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
        Favorite favorite = new Favorite();
        favorite.setProduct(product.get());
        favorite.setUser(user);
        favoriteRepository.save(favorite);
        product.get().setFavorite(favorite);
        productRepository.save(product.get());
        List<Favorite> favorites = user.getFavorites();
        favorites.add(favorite);
        user.setFavorites(favorites);
        userRepository.save(user);

    }

    @Override
    public void deleteFav(Long productId, String token) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isEmpty()) {
            throw new NotFoundException("This product doesn't exist!", HttpStatus.NOT_FOUND);
        }

        Product product = productOptional.get();
        if (product.getFavorite() == null) {
            throw new NotFoundException("This product is not a favorite!", HttpStatus.NOT_FOUND);
        }

        Favorite favorite = product.getFavorite();
        favoriteRepository.deleteById(favorite.getId());

        product.setFavorite(null);
        productRepository.save(product);
    }

    @Override
    public FavoriteResponse getFav(Long favoriteId, String token) {
        System.out.println("fgfhgf");
        Optional<Favorite> favorite = favoriteRepository.findById(favoriteId);
        if (favorite.isEmpty()) {
            throw new NotFoundException("Favorite with this id doesn't exist: " + favoriteId + "!", HttpStatus.BAD_REQUEST);
        }
        return favoriteMapper.toDto(favorite.get());
    }

    @Override
    public List<FavoriteResponse> getUsersFav(String token) {
        User user = authService.getUsernameFromToken(token);
        return favoriteMapper.toDtos(user.getFavorites());
    }
}
