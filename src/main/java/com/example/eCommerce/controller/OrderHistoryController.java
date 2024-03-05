 package com.example.eCommerce.controller;

import com.example.eCommerce.dto.product.ProductResponse;
import com.example.eCommerce.repositories.UserRepository;
import com.example.eCommerce.service.payment.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@RequestMapping("/history")
public class OrderHistoryController {
    private final UserRepository userRepository;
    private final PaymentService paymentService;
//     @DateTimeFormat(pattern = "MM/dd/yyyy")
    @GetMapping("/findByDate/{date}")
    public void findByDate(@PathVariable LocalDate date){

    }


}
