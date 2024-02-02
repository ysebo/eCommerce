package com.example.eCommerce.service.product;

import com.example.eCommerce.dto.Product.ProductRequest;
import com.example.eCommerce.dto.Product.ProductResponse;

public interface ProductService {
    void addProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long id);

    void deleteProductById(Long id);

    ProductResponse getProductByUnicode(String unicode);
}
