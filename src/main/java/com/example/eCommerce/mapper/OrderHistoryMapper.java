package com.example.eCommerce.mapper;

import com.example.eCommerce.dto.order.OrderHistoryResponse;
import com.example.eCommerce.entities.OrderHistory;

import java.util.List;

public interface OrderHistoryMapper {
    List<OrderHistoryResponse> toDtos(List<OrderHistory> orderHistories);
    OrderHistoryResponse toDto(OrderHistory orderHistory);
}
