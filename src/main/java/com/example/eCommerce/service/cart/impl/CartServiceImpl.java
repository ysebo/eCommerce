package com.example.eCommerce.service.cart.impl;

import com.example.eCommerce.dto.cart.CartRequest;
import com.example.eCommerce.entities.Cart;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.entities.User;
import com.example.eCommerce.repositories.CartRepostitory;
import com.example.eCommerce.repositories.ProductRepository;
import com.example.eCommerce.service.auth.AuthService;
import com.example.eCommerce.service.cart.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final AuthService authService;
    private final CartRepostitory cartRepostitory;
    private final ProductRepository productRepository;


    @Override
    public void add(CartRequest cartRequest, String token) {
        User user = authService.getUsernameFromToken(token);
        Cart cart = cartRepostitory.findById(user.getId()).get();
        Cart cart1 = new Cart();
        Optional<Product> product = productRepository.findById(cartRequest.getProductId());
        cart1.setSKU(product.get().getSKU());
        cart1.setQuantity(cartRequest.getQuantity());
        cart1.setPrice(product.get().getPrice());
        cart1.setUser(product.get().getUser());
        cartRepostitory.save(cart1);
    }
}
