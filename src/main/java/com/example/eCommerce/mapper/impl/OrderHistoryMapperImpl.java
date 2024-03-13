package com.example.eCommerce.mapper.impl;

import com.example.eCommerce.dto.order.OrderHistoryResponse;
import com.example.eCommerce.entities.OrderHistory;
import com.example.eCommerce.mapper.OrderHistoryMapper;
import com.example.eCommerce.service.orderHistory.OrderHistoryService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderHistoryMapperImpl implements OrderHistoryMapper {

    @Override
    public List<OrderHistoryResponse> toDtos(List<OrderHistory> orderHistories) {
        List<OrderHistoryResponse> responses = new ArrayList<>();
        for(OrderHistory orderHistory:orderHistories){
            responses.add(toDto(orderHistory));
        }
        return  responses;
    }
    @Override
    public OrderHistoryResponse toDto(OrderHistory orderHistory){
        OrderHistoryResponse orderHistoryResponse = new OrderHistoryResponse();
        orderHistoryResponse.setId(orderHistory.getOrderId());
        orderHistoryResponse.setName(orderHistory.getName());
        orderHistoryResponse.setTotal(orderHistory.getTotal());
        orderHistoryResponse.setPrice(orderHistory.getPrice());
        orderHistoryResponse.setQuantity(orderHistory.getQuantity());
        orderHistoryResponse.setCreateDate(orderHistory.getCreateDate());
        return orderHistoryResponse;
    }

}
