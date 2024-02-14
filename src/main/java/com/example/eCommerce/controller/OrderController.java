package com.example.eCommerce.controller;

import com.example.eCommerce.dto.payment.PaymentDetailsRegisterRequest;
import com.example.eCommerce.dto.payment.PaymentDetailsRegisterResponse;
import com.example.eCommerce.repositories.UserRepository;
import com.example.eCommerce.service.payment.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final UserRepository userRepository;
    private final PaymentService paymentService;
    @PostMapping("/register")
    public void register(@RequestBody PaymentDetailsRegisterRequest userRequest){
        paymentService.register(userRequest);
    }
    @GetMapping("/{id}")
    public PaymentDetailsRegisterResponse getById(@PathVariable Long id){
        return paymentService.getById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id ){
        paymentService.deleteById(id);

    }
}
