package com.example.eCommerce.service.cart.impl;

import com.example.eCommerce.dto.cart.CartRequest;
import com.example.eCommerce.dto.cart.CartResponse;
import com.example.eCommerce.entities.*;
import com.example.eCommerce.exception.BadRequestException;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.mapper.CartMapper;
import com.example.eCommerce.repositories.CartItemRepository;
import com.example.eCommerce.repositories.CartRepostitory;
import com.example.eCommerce.repositories.OrderHistoryRepository;
import com.example.eCommerce.repositories.ProductRepository;
import com.example.eCommerce.service.auth.AuthService;
import com.example.eCommerce.service.cart.CartService;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import org.aspectj.lang.reflect.NoSuchAdviceException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final AuthService authService;
    private final CartRepostitory cartRepostitory;
    private final ProductRepository productRepository;
    private final CartMapper cartMapper;
    private final CartItemRepository cartItemRepository;


    @Override
    public void addToCart(CartRequest cartRequest, String token) {
        User user = authService.getUsernameFromToken(token);
        Cart cart = cartRepostitory.findById(user.getId()).get();
        Optional<Product> product = productRepository.findById(cartRequest.getProductId());
        if(product.isEmpty()){
            throw new BadRequestException("Product with id " + cartRequest.getProductId()+ "doesn't exist!!!");
        }
        Optional<CartItem> Items = cartItemRepository.findById(cartRequest.getProductId());
        if(Items.isPresent()){
            throw new BadRequestException("Product already exist in cart!");
        }
        if(Items.get().getTotal().equals(100000)) {
            throw new BadRequestException("You can't add to cart , your cart is full");
        }
        CartItem item = new CartItem();
        item.setName(product.get().getName());
        item.setSKU(product.get().getSKU());
        item.setPrice(product.get().getPrice());
        item.setQuantity(cartRequest.getQuantity());
        item.setSubtotal(product.get().getPrice()* cartRequest.getQuantity());
        item.setCart(user.getCart());
        CartItem cartItem = cartItemRepository.saveAndFlush(item);
        List<CartItem > items = new ArrayList<>();
        if(cart.getCartItems()!= null)items = cart.getCartItems();
        items.add(cartItem);
        cart.setCartItems(items);
        cartRepostitory.save(cart);
    }
    @Override
    public void buy( String token) {
        User user = authService.getUsernameFromToken(token);
        Cart cart = cartRepostitory.findById(user.getId()).get();
        if(cart.getCartItems().size() == 0){
            throw new BadRequestException("Your can't buy , your cart is empty");
        }
        List<CartItem>items = cart.getCartItems();
        for (CartItem item:items )item.setCart(null);
        cart.setCartItems(null);
        cartRepostitory.save(cart);
        for (CartItem item : items )cartItemRepository.delete(item);
    }

    @Override
    public CartResponse getCart(String token) {
        User user = authService.getUsernameFromToken(token);
        Cart cart = cartRepostitory.findById(user.getId()).get();
        return cartMapper.toDto(cart);
    }


    @Override
    public void deleteCart(CartRequest cartRequest, String token) {
        User user = authService.getUsernameFromToken(token);
        Cart cart = cartRepostitory.findById(user.getId()).get();
        Optional<CartItem> item = cartItemRepository.findById(cartRequest.getProductId());
        if(item.isEmpty()){
            throw  new BadRequestException("Product with "+ cartRequest.getProductId()+ "doesn't exist");
        }
        if(item.get().getCart() != cart){
            throw new BadRequestException("You can't delete it");
        }
        cart.getCartItems().remove(item);
        cartRepostitory.save(cart);
        item.get().setCart(null);
        cartItemRepository.save(item.get());


    }

    @Override
    public void updateCart(CartRequest cartRequest, String token) {
        User user = authService.getUsernameFromToken(token);
        Cart cart = cartRepostitory.findById(user.getId()).get();
        Optional<CartItem> item = cartItemRepository.findById(cartRequest.getProductId());
        if(item.isEmpty())
            throw new BadRequestException("Product with id: " + cartRequest.getProductId() + "  doesn't exist!");
        if(item.get().getCart()!= cart){
            throw  new BadRequestException("Product with id: "+ cartRequest.getProductId()+ "can't be updated!");
        }
        item.get().setQuantity(cartRequest.getQuantity());
        item.get().setSubtotal(cartRequest.getQuantity()*item.get().getPrice());
        cartItemRepository.save(item.get());
    }
}
