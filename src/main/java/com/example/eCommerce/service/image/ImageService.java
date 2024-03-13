package com.example.eCommerce.service.image;

import com.example.eCommerce.dto.image.ImageResponse;
import com.example.eCommerce.entities.Image;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface ImageService {
    @Transactional
    Image uploadFile(MultipartFile file, Image oldDocument);

    Image uploadFile(MultipartFile file);

    void uploadFileToS3Bucket(MultipartFile file);

    byte[] downloadFile(String fileName);

    void deleteFile(Long id);

    ImageResponse getById(Long id);
}
