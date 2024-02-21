package com.example.eCommerce.service.cart;

import com.example.eCommerce.dto.cart.CartRequest;
import com.example.eCommerce.dto.cart.CartResponse;
import com.example.eCommerce.entities.Cart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


public interface CartService {
    void add(CartRequest cartRequest , String token );
    CartResponse get(String token);
    void delete(CartRequest cartRequest , String token);
}
