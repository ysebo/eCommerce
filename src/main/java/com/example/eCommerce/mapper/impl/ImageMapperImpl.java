package com.example.eCommerce.mapper.impl;

import com.example.eCommerce.dto.image.ImageResponse;
import com.example.eCommerce.entities.Image;
import com.example.eCommerce.mapper.ImageMapper;
import org.springframework.stereotype.Component;

@Component
public class ImageMapperImpl implements ImageMapper {
    @Override
    public ImageResponse toDto(Image image) {
        ImageResponse imageResponse = new ImageResponse();
        imageResponse.setProductId(image.getProduct().getId());
        imageResponse.setPath(image.getPath());
        imageResponse.setId(image.getId());
        imageResponse.setName(image.getName());
        return imageResponse;
    }
}
