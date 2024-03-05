package com.example.eCommerce.mapper.impl;

import com.example.eCommerce.dto.cart.CartResponse;
import com.example.eCommerce.entities.Cart;
import com.example.eCommerce.entities.CartItem;
import com.example.eCommerce.mapper.CartMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartMapperImpl implements CartMapper{
    @Override
    public CartResponse toDto(Cart cart) {
        CartResponse cartResponse = new CartResponse();
        List<String> names = new ArrayList<>();
        List<Integer> prices = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        List<Integer> subtotals = new ArrayList<>();
        Integer total =0;
        List<CartItem> items = cart.getCartItems();
        for(CartItem item:items){
            names.add(item.getName());
            prices.add(item.getPrice());
            quantities.add(item.getQuantity());
            subtotals.add(item.getSubtotal());
            total+= item.getSubtotal();
        }
        return cartResponse;
    }
}
