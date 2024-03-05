package com.example.eCommerce.service.orderHistory.impl;

import com.example.eCommerce.dto.order.OrderHistoryResponse;
import com.example.eCommerce.entities.User;
import com.example.eCommerce.mapper.OrderHistoryMapper;
import com.example.eCommerce.service.auth.AuthService;
import com.example.eCommerce.service.orderHistory.OrderHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderHistoryServiceImpl implements OrderHistoryService{
    private final OrderHistoryMapper orderHistoryMapper;
    private final AuthService authService;
    @Override
    public List<OrderHistoryResponse> all(String token) {
        User user = authService.getUsernameFromToken(token);
        return orderHistoryMapper.toDtos(user.getOrderHistories());
    }

}
