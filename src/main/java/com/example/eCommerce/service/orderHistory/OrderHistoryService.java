package com.example.eCommerce.service.orderHistory;

import com.example.eCommerce.dto.order.OrderHistoryResponse;

import java.util.List;

public interface OrderHistoryService {
    List<OrderHistoryResponse> all(String token);
}
