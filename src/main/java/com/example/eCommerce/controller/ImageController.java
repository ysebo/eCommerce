package com.example.eCommerce.controller;

import com.example.eCommerce.dto.image.ImageResponse;
import com.example.eCommerce.service.image.ImageService;
import com.example.eCommerce.repositories.*;
import com.example.eCommerce.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/image")
public class ImageController {

    private final ProductService productService;
    private final ImageService imageService;

    @PostMapping("/upload/{productId}")
    public String uploadFile(@RequestHeader("Authorization") String token, @RequestParam(value = "file") MultipartFile file, @PathVariable Long productId) {
        productService.uploadFile(token, file, productId);
//        imageService.uploadFile(file);
        return "Image uploaded successfully!";
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        byte[] data = imageService.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFile(@PathVariable Long id) {
        imageService.deleteFile(id);
        return "Image deleted successfully!";
    }

    @GetMapping("{id}")
    public ImageResponse getById(@PathVariable Long id){
        return imageService.getById(id);
    }


}
