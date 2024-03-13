package com.example.eCommerce.mapper;

import com.example.eCommerce.dto.image.ImageResponse;
import com.example.eCommerce.entities.Image;

public interface ImageMapper{
    ImageResponse toDto(Image image);
}
