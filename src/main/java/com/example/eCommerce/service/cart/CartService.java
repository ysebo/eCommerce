package com.example.eCommerce.service.cart;

import com.example.eCommerce.dto.cart.CartItemResponse;
import com.example.eCommerce.dto.cart.CartRequest;
import com.example.eCommerce.dto.cart.CartResponse;
import com.example.eCommerce.entities.Cart;
import com.example.eCommerce.entities.CartItem;
import com.example.eCommerce.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartService {
    void addToCart(Long id ,CartRequest cartRequest , String token );
    List<CartItemResponse> getCart(String token);
    void deleteCart(Long id, String token);
    void updateCart(Long id  ,CartRequest cartRequest , String token);
    void buy( String token );
    void addToHistory(CartItem cartItem , User user);
}
