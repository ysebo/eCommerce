 package com.example.eCommerce.controller;

import com.example.eCommerce.dto.order.OrderHistoryResponse;
import com.example.eCommerce.dto.product.ProductResponse;
import com.example.eCommerce.repositories.OrderHistoryRepository;
import com.example.eCommerce.repositories.UserRepository;
import com.example.eCommerce.service.orderHistory.OrderHistoryService;
import com.example.eCommerce.service.payment.PaymentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

 @RestController
@AllArgsConstructor
@RequestMapping("/history")
public class OrderHistoryController {
    private final OrderHistoryService orderHistoryService;
    @GetMapping("/all")
    public List<OrderHistoryResponse>all(@RequestHeader("Authorization") String token){
        return orderHistoryService.all(token);
    }
    @GetMapping("/{id}")
     public OrderHistoryResponse getById(@RequestHeader("Authorization")String token , @PathVariable Long id ){
        return orderHistoryService.getById(token, id);
    }


}
