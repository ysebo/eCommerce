package com.example.eCommerce.controller;

import com.example.eCommerce.dto.cart.CartItemResponse;
import com.example.eCommerce.dto.cart.CartRequest;
import com.example.eCommerce.dto.cart.CartResponse;
import com.example.eCommerce.entities.Cart;
import com.example.eCommerce.repositories.ProductRepository;
import com.example.eCommerce.service.cart.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final ProductRepository productRepository;
    private final CartService cartService;
    @PostMapping("/add/{productId}")
    public String addToCart(@PathVariable Long productId , @RequestBody CartRequest cartRequest, @RequestHeader("Authorization") String token) {
        cartService.addToCart(productId, cartRequest, token);
        return "Product was added to cart successfully!";
    }

    @PostMapping("/buy")
    public String buyCart( @RequestHeader("Authorization") String token) {
        cartService.buy(token );
        return ("Product was bought successfully!");
    }

    @GetMapping("/get")
    public List<CartItemResponse> showCart(@RequestHeader("Authorization")String token){
        return cartService.getCart(token);
    }
    @DeleteMapping("/delete/{productId}")
    public String deleteFromCart(@PathVariable Long productId, @RequestHeader("Authorization")String token ){
        cartService.deleteCart(productId, token );
        return "Product was deleted from cart successfully!";
    }
    @PutMapping("/update/{id}")
    public String updateCart(@PathVariable Long id,@RequestBody CartRequest cartRequest , @RequestHeader("Authorization")String token) {
        cartService.updateCart(id , cartRequest, token);
        return ("Quantity was updated!");
    }
}
