package com.example.eCommerce.controller;

import com.example.eCommerce.dto.Payment.PaymentDetailsRegisterRequest;
import com.example.eCommerce.dto.Payment.PaymentDetailsRegisterResponse;
import com.example.eCommerce.repositories.UserRepository;
import com.example.eCommerce.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final UserRepository userRepository;
    private final UserService userService;
//    @PostMapping("/register")
//    public void register(@RequestBody PaymentDetailsRegisterRequest userRequest){
//        userService.register(userRequest);
//    }
    @GetMapping("/{id}")
    public PaymentDetailsRegisterResponse getById(@PathVariable Long id){
        return userService.getById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id ){
        userService.deleteById(id);

    }
}
