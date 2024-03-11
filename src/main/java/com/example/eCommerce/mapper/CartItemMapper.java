package com.example.eCommerce.mapper;

import com.example.eCommerce.dto.cart.CartItemResponse;
import com.example.eCommerce.dto.product.ProductResponse;
import com.example.eCommerce.entities.CartItem;
import com.example.eCommerce.entities.Product;

import java.util.List;

public interface CartItemMapper {
    CartItemResponse dto(CartItem cartItem);
    List<CartItemResponse> toDtos(List<CartItem> all);
}
