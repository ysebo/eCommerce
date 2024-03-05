package com.example.eCommerce.dto.order;

import com.example.eCommerce.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

public class OrderHistoryResponse {
    private Long id ;
    private LocalDateTime createDate;
    private Integer total;
    private String name;
    private Integer quantity;
    private Integer price;

}
