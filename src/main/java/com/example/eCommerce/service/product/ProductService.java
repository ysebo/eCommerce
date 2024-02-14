package com.example.eCommerce.service.product;

import com.example.eCommerce.dto.product.ProductRequest;
import com.example.eCommerce.dto.product.ProductResponse;

import java.util.List;
public interface ProductService {
    void addProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long id);

    void deleteProductById(Long id);

    ProductResponse getProductBySKU(String SKU);
    void updateProductById(Long id, ProductRequest productRequest);
    List<ProductResponse> all();
}
