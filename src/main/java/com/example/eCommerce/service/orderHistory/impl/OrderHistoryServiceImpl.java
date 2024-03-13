package com.example.eCommerce.service.orderHistory.impl;

import com.example.eCommerce.dto.order.OrderHistoryResponse;
import com.example.eCommerce.entities.OrderHistory;
import com.example.eCommerce.entities.User;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.mapper.OrderHistoryMapper;
import com.example.eCommerce.repositories.OrderHistoryRepository;
import com.example.eCommerce.service.auth.AuthService;
import com.example.eCommerce.service.orderHistory.OrderHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderHistoryServiceImpl implements OrderHistoryService{
    private final OrderHistoryMapper orderHistoryMapper;
    private final AuthService authService;
    private final OrderHistoryRepository orderHistoryRepository;
    @Override
    public List<OrderHistoryResponse> all(String token) {
        User user = authService.getUsernameFromToken(token);
        return orderHistoryMapper.toDtos(user.getOrderHistories());
    }

    @Override
    public OrderHistoryResponse getById(String token, Long id) {
        User user = authService.getUsernameFromToken(token);
        Optional<OrderHistory> order = orderHistoryRepository.findById(id);
        if(order.isEmpty() || order.get().getUser() != user)
            throw new NotFoundException("Order was not found!" , HttpStatus.NOT_FOUND);
        return orderHistoryMapper.toDto(order.get());
    }

}
