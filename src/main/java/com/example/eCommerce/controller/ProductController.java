package com.example.eCommerce.controller;

import com.example.eCommerce.dto.restock.RestockRequest;
import com.example.eCommerce.dto.product.CategoryRequest;
import com.example.eCommerce.dto.product.ProductComparisonResponse;
import com.example.eCommerce.dto.product.ProductRequest;
import com.example.eCommerce.dto.product.ProductResponse;
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
    public String addProduct(@RequestBody ProductRequest productRequest){
        productService.addProduct(productRequest);

        return  "Product " + productRequest.getName() + " was added successfully";
    }
    @GetMapping("/getBy/{id}")
    public ProductResponse getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @DeleteMapping("/deleteBy/{id}")
    public String deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return "Product with id :" + id + " was deleted successfully";
    }

    @GetMapping("/getBySKU/{SKU}")
    public ProductResponse getProductBySKU(@PathVariable String SKU){
        return productService.getProductBySKU(SKU);
    }
    @PutMapping("/restock/{id}")
    public String restock(@PathVariable Long id , @RequestBody RestockRequest restockRequest ){
        productService.restockProduct( id , restockRequest);
        return "Product was successfully restocked!";
    }
    @PutMapping("/updateBy/{id}")
    public String updateProductById(@PathVariable Long id, @RequestBody ProductRequest productRequest){
        productService.updateProductById(id, productRequest);
        return "Product with id: " +id + " was updated successfully ";
    }
    @GetMapping("/getAll")
    public List<ProductResponse> all(){
        return productService.all();
    }
    @PostMapping("/add/category")
    public String addCategory(@RequestBody CategoryRequest request){
        productService.addCategory(request);
        return "Category: " + request.getName() + " was added successfully!";
    }

    @GetMapping("/getComparableProduct/{id}/{id2}")
    public List<ProductComparisonResponse> getComparableProduct(@PathVariable Long id ,@PathVariable Long id2){
        return productService.getComparableProduct(id , id2);
    }
}
