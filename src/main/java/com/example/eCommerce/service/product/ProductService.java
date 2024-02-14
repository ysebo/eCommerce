package com.example.eCommerce.service.product;

import com.example.eCommerce.dto.product.CategoryRequest;
import com.example.eCommerce.dto.product.ProductComparisonResponse;
import com.example.eCommerce.dto.product.ProductRequest;
import com.example.eCommerce.dto.product.ProductResponse;

import java.util.List;
public interface ProductService {
    void addProduct(ProductRequest ProductRequest);

    ProductResponse getProductById(Long id);

    void deleteProductById(Long id);

    ProductResponse getProductBySKU(String SKU);
    void updateProductById(Long id, ProductRequest ProductRequest);
    List<ProductResponse> all();
    void addCategory(CategoryRequest request);


    ProductComparisonResponse getComparableProduct(Long id);
}
