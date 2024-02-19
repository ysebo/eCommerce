package com.example.eCommerce.controller;

import com.example.eCommerce.dto.cart.CartRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {
//    @PostMapping("/add")
//    public addToCart(@RequestBody CartRequest cartRequest , @RequestHeader("Authorization ")String token){
//        cartService.add(cartRequest , token );
//        return productRepository.findById(cartRequest.getProductId().get().getName());
//    }
}
