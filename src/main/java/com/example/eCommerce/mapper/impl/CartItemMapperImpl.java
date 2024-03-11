package com.example.eCommerce.mapper.impl;

import com.example.eCommerce.dto.cart.CartItemResponse;
import com.example.eCommerce.entities.CartItem;
import com.example.eCommerce.mapper.CartItemMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartItemMapperImpl implements CartItemMapper {
    @Override
    public CartItemResponse dto(CartItem cartItem) {
        CartItemResponse cartItemResponse = new CartItemResponse();
        cartItemResponse.setId(cartItem.getId());
        cartItemResponse.setQuantity(cartItem.getQuantity());
        cartItemResponse.setSKU(cartItem.getSKU());
        cartItemResponse.setPrice(cartItem.getPrice());
        cartItemResponse.setName(cartItem.getName());
        cartItemResponse.setTotal(cartItem.getTotal());
        return cartItemResponse;
    }

    @Override
    public List<CartItemResponse> toDtos(List<CartItem> all) {
        List<CartItemResponse> cartItems = new ArrayList<>();
        for(CartItem item : all){
            cartItems.add(dto(item));
        }
        return cartItems;
    }
}
