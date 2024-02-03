package com.example.eCommerce.service.product.Impl;

import com.example.eCommerce.dto.Product.ProductRequest;
import com.example.eCommerce.dto.Product.ProductResponse;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.mapper.ProductMapper;
import com.example.eCommerce.repositories.ProductRepository;
import com.example.eCommerce.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public void addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        productRepository.save(product);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty())
            throw new NotFoundException("product not found with id:"+id+"!", HttpStatus.BAD_REQUEST);
        return productMapper.toDto(product.get());
    }

    @Override
    public void deleteProductById(Long id) {
        if (productRepository.findById(id).isEmpty())
            throw new NotFoundException("product not found with id:"+id+"!", HttpStatus.BAD_REQUEST);
        productRepository.deleteById(id);
    }

    @Override
    public ProductResponse getProductByUnicode(String unicode) {
        Product product = productRepository.findByUnicode(unicode);
        if (product == null) {
            throw new NotFoundException("Product not found with unicode: " + unicode + "!", HttpStatus.NOT_FOUND);
        }
        return productMapper.toDto(product);
    }
}
