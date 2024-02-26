package com.example.eCommerce.service.cart.impl;

import com.example.eCommerce.dto.cart.CartRequest;
import com.example.eCommerce.dto.cart.CartResponse;
import com.example.eCommerce.entities.Cart;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.entities.User;
import com.example.eCommerce.exception.BadRequestException;
import com.example.eCommerce.mapper.CartMapper;
import com.example.eCommerce.repositories.CartRepostitory;
import com.example.eCommerce.repositories.ProductRepository;
import com.example.eCommerce.service.auth.AuthService;
import com.example.eCommerce.service.cart.CartService;
import lombok.AllArgsConstructor;
import org.aspectj.lang.reflect.NoSuchAdviceException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final AuthService authService;
    private final CartRepostitory cartRepostitory;
    private final ProductRepository productRepository;
    private final CartMapper cartMapper;

    @Override
    public void add(CartRequest cartRequest, String token) {
        User user = authService.getUsernameFromToken(token);
        Cart cart = cartRepostitory.findById(user.getId()).get();
        Optional<Product> product = productRepository.findById(cartRequest.getProductId());
        if(product.isEmpty()){
            throw new BadRequestException("Product with id " + cartRequest.getProductId()+ "doesn't exist!!!");
        }
        Optional<Cart>carts = cartRepostitory.findById(cartRequest.getProductId());
        if(carts.isPresent()){
            throw new BadRequestException("Product already exist in cart!");
        }
        Cart cart1 = new Cart();
        cart1.setSKU(product.get().getSKU());
        cart1.setQuantity(cartRequest.getQuantity());
        cart1.setPrice(product.get().getPrice());
        cartRepostitory.save(cart1);
    }

    @Override
    public CartResponse get(String token) {
        User user = authService.getUsernameFromToken(token);
        Cart cart = cartRepostitory.findById(user.getId()).get();
        return cartMapper.toDto(cart);
    }


    @Override
    public void delete(CartRequest cartRequest, String token) {
        User user = authService.getUsernameFromToken(token);
        Cart cart = cartRepostitory.findById(user.getId()).get();
        Optional<Cart>carts = cartRepostitory.findById(cartRequest.getProductId());
        if(carts.isEmpty()){
            throw  new BadRequestException("Product with "+ cartRequest.getProductId()+ "doesn't exist");
        }



    }
}
