package com.example.eCommerce.mapper.impl;

import com.example.eCommerce.dto.cart.CartResponse;
import com.example.eCommerce.entities.Cart;
import com.example.eCommerce.mapper.CartMapper;
import org.springframework.stereotype.Component;

@Component
public class CartMapperImpl implements CartMapper{
    @Override
    public CartResponse toDto(Cart cart) {
        CartResponse cartResponse = new CartResponse();
        cartResponse.setPrice(cart.getPrice());
        cartResponse.setSKU(cart.getSKU());
        cartResponse.setQuantity(cart.getQuantity());
        return cartResponse;
    }
}
