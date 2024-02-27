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
    public String addToCart(@RequestBody CartRequest cartRequest, @RequestHeader("Authorization-Bearer") String token) {
        cartService.addToCart(cartRequest, token);
        return "Product was added to cart successfully!";
    }

    @PostMapping("/buy")
    public String buyCart( @RequestHeader("Authorization-Bearer") String token) {
        cartService.buy(token );
        return ("Product was bought successfully!");
    }

    @GetMapping("/get/{cartId}")
    public CartResponse showCart(@RequestHeader("Authorization-Bearer")String token){
        return cartService.getCart(token);
    }
    @DeleteMapping("/delete")
    public String deleteFromCart(@RequestBody CartRequest cartRequest , @RequestHeader("Authorization-Bearer")String token ){
        cartService.deleteCart(cartRequest, token );
        return "Product was deleted from cart successfully!";
    }
    @PutMapping("/update")
    public String updateCart(@RequestBody CartRequest cartRequest , @RequestHeader("Authorization-Bearer")String token) {
        cartService.updateCart(cartRequest, token);
        return ("Quantity was updated!");
    }
}
