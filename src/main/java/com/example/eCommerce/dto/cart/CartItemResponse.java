package com.example.eCommerce.dto.cart;

import com.example.eCommerce.entities.OrderHistory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartItemResponse {
    private Long id;
    private String name;
    private String SKU;
    private Integer quantity;
    private Integer price;
    private Integer subtotal;
    private Integer total;
    private List<OrderHistory> orderHistories;

}
