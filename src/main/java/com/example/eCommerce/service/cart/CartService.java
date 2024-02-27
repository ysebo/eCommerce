package com.example.eCommerce.service.cart;

import com.example.eCommerce.dto.cart.CartRequest;
import com.example.eCommerce.dto.cart.CartResponse;
import com.example.eCommerce.entities.Cart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


public interface CartService {
    void addToCart(CartRequest cartRequest , String token );
    CartResponse getCart(String token);
    void deleteCart(CartRequest cartRequest , String token);
    void updateCart(CartRequest cartRequest , String token);
    void buy( String token );
}
