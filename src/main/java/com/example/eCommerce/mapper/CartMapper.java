package com.example.eCommerce.mapper;

import com.example.eCommerce.dto.cart.CartResponse;
import com.example.eCommerce.entities.Cart;

public interface CartMapper {
    CartResponse toDto(Cart cart);
}
