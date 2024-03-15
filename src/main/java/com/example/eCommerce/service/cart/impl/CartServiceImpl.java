package com.example.eCommerce.service.cart.impl;

import com.example.eCommerce.dto.cart.CartItemResponse;
import com.example.eCommerce.dto.cart.CartRequest;
import com.example.eCommerce.dto.cart.CartResponse;
import com.example.eCommerce.entities.*;
import com.example.eCommerce.exception.BadRequestException;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.mapper.CartItemMapper;
import com.example.eCommerce.mapper.CartMapper;
import com.example.eCommerce.repositories.*;
//import com.example.eCommerce.repositories.OrderHistoryRepository;
import com.example.eCommerce.service.auth.AuthService;
import com.example.eCommerce.service.cart.CartService;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import org.aspectj.lang.reflect.NoSuchAdviceException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private final OrderHistoryRepository orderHistoryRepository;
    private final UserRepository userRepository;
    private final CartItemMapper cartItemMapper;

    @Override
    public void addToCart(Long productId, CartRequest cartRequest, String token) {
        User user = authService.getUsernameFromToken(token);
//        Cart cart = cartRepostitory.findById(user.getId()).get();
        Optional<Cart> cart = cartRepostitory.findById(user.getCart().getId());
        if(cart.isEmpty()){
            throw new BadRequestException("cart is null");
        }
        Optional<Product> product = productRepository.findById(productId);
        if(product.isEmpty()){
            throw new BadRequestException("Product with id " + productId+ " doesn't exist!!!");
        }
        Optional<CartItem> Items = cartItemRepository.findById(productId);
        if(Items.isPresent()){
            throw new BadRequestException("Product already exist in cart!");
        }
        if(cart.get().getCartItems().size()==10  ) {
            throw new BadRequestException("You can't add to cart , your cart is full");
        }
        CartItem item = new CartItem();
        item.setName(product.get().getName());
        item.setSKU(product.get().getSKU());
        item.setPrice(product.get().getPrice());
        item.setQuantity(product.get().getQuantity());
        item.setSubtotal(product.get().getPrice()* cartRequest.getQuantity());
        item.setCart(user.getCart());
        CartItem cartItem = cartItemRepository.saveAndFlush(item);
        List<CartItem > items = new ArrayList<>();
        if(cart.get().getCartItems()!= null)items = cart.get().getCartItems();
        items.add(cartItem);
        cart.get().setCartItems(items);
        cartRepostitory.save(cart.get());
    }
    @Override
    public void buy( String token) {
        User user = authService.getUsernameFromToken(token);
        Cart cart = cartRepostitory.findById(user.getCart().getId()).get();

        if(cart.getCartItems().size() == 0){
            throw new BadRequestException("Your can't buy , your cart is empty");
        }
        List<CartItem>items = cart.getCartItems();
        for (CartItem item:items ) {
            item.setCart(null);
            addToHistory(item, user);
            item.setCart(null);
        }
        cart.setCartItems(null);
        cartRepostitory.save(cart);
        cartItemRepository.deleteAll(items);
        for (CartItem item : items)cartItemRepository.delete(item);

    }

    @Override
    public void addToHistory(CartItem cartItem, User user) {
        OrderHistory orderHistory  = new OrderHistory();
        orderHistory.setTotal(cartItem.getTotal());
        orderHistory.setName(cartItem.getName());
        orderHistory.setQuantity(cartItem.getQuantity());
        orderHistory.setPrice(cartItem.getPrice());
        orderHistory.setCreateDate(LocalDateTime.now());
        orderHistory.setUser(user);
        OrderHistory orderHistory1 = orderHistoryRepository.saveAndFlush(orderHistory);
        List<OrderHistory > orderHistories = new ArrayList<>();
        if(!user.getOrderHistories().isEmpty())
            orderHistories = user.getOrderHistories();
        orderHistories.add(orderHistory1);
        user.setOrderHistories(orderHistories);
        userRepository.save(user);
    }


    @Override
    public List<CartItemResponse> getCart(String token) {
        User user = authService.getUsernameFromToken(token);
        Cart cart = cartRepostitory.findById(user.getCart().getId()).get();
        return cartItemMapper.toDtos(cart.getCartItems());
    }


    @Override
    public void deleteCart(Long id, String token) {
        User user = authService.getUsernameFromToken(token);
        Cart cart = user.getCart();
        Optional<CartItem> item = cartItemRepository.findById(id);
        if(item.isEmpty()){
            throw  new BadRequestException("Product with "+ id+ " doesn't exist");
        }
        if(item.get().getCart() != cart){
            throw new BadRequestException("You can't delete it");
        }
        cart.getCartItems().remove(item.get());
        cartItemRepository.deleteById(id);


    }

    @Override
    public void updateCart(Long id , CartRequest cartRequest, String token) {
        User user = authService.getUsernameFromToken(token);
        Cart cart = cartRepostitory.findById(user.getId()).get();
        Optional<CartItem> item = cartItemRepository.findById(id);
        if(item.isEmpty())
            throw new BadRequestException("Product with id: " + id + "  doesn't exist!");
        if(item.get().getCart()!= cart){
            throw  new BadRequestException("Product with id: "+ id+ "can't be updated!");
        }
        item.get().setQuantity(cartRequest.getQuantity());
        item.get().setSubtotal(cartRequest.getQuantity()*item.get().getPrice());
        cartItemRepository.save(item.get());
    }
}
