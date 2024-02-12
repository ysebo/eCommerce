package com.example.eCommerce.controller;

import com.example.eCommerce.dto.Product.ProductRequest;
import com.example.eCommerce.dto.Product.ProductResponse;
import com.example.eCommerce.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    @PostMapping("/add")
    public void addProduct(@RequestBody ProductRequest productRequest){
        productService.addProduct(productRequest);
    }
    @GetMapping("/getBy{id}")
    public ProductResponse getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/deleteBy/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @GetMapping("/getBySKU/{SKU}")
    public ProductResponse getProductBySKU(@PathVariable String SKU){
        return productService.getProductBySKU(SKU);
    }
    @GetMapping("/getAll")
    public List<ProductResponse> all(){
        return productService.all();
    }

    @PutMapping("/updateProduct/{id}")
    public void updateProductById(@PathVariable Long id, @RequestBody ProductRequest productRequest){
        productService.updateProductById(id, productRequest);
    }
}
