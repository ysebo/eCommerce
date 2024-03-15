package com.example.eCommerce.dto.image;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageResponse {
    private Long id;
    private String name;
    private String path ;
    private Long productId;
}
