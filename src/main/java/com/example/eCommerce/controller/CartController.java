package com.example.eCommerce.controller;

import com.example.eCommerce.dto.cart.CartRequest;
import com.example.eCommerce.dto.cart.CartResponse;
import com.example.eCommerce.entities.Cart;
import com.example.eCommerce.repositories.ProductRepository;
import com.example.eCommerce.service.cart.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final ProductRepository productRepository;
    private final CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestBody CartRequest cartRequest , @RequestHeader("Authorization-Bearer")String token){
        cartService.add(cartRequest , token );
        return "Product was added to cart successfully!";
    }
    @GetMapping("/get/{cartId}")
    public CartResponse showCart(@RequestHeader("Authorization-Bearer")String token){
        return cartService.get(token);
    }
    @DeleteMapping("/delete")
    public String deleteFromCart(@RequestBody CartRequest cartRequest , @RequestHeader("Authorization-Bearer")String token ){
        cartService.delete(cartRequest, token );
        return "Product was deleted from cart successfully!";
    }

}
