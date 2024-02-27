package com.example.eCommerce.dto.cart;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter


public class CartResponse {
    private Integer total;
    private List<String>names;
    private List<Integer>prices;
    private List<Integer>subtotals;
    private List<Integer>quantitys;



}

