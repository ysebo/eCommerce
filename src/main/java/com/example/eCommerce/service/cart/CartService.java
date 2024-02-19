package com.example.eCommerce.service.cart;

import com.example.eCommerce.dto.cart.CartRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


public interface CartService {
    void add(CartRequest cartRequest , String token );
}
