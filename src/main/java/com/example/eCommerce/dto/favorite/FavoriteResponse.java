package com.example.eCommerce.dto.favorite;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FavoriteResponse {
    private Long id ;
    private Long productId;
    private Long userId;
}
