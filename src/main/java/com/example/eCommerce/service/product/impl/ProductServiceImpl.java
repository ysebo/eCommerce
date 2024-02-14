package com.example.eCommerce.service.product.impl;

import com.example.eCommerce.dto.product.CategoryRequest;
import com.example.eCommerce.dto.product.ProductComparisonResponse;
import com.example.eCommerce.dto.product.ProductRequest;
import com.example.eCommerce.dto.product.ProductResponse;
import com.example.eCommerce.entities.Category;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.exception.BadRequestException;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.mapper.ComparableProductMapper;
import com.example.eCommerce.mapper.ProductMapper;
import com.example.eCommerce.repositories.CategoryRepository;
import com.example.eCommerce.repositories.ProductRepository;


import com.example.eCommerce.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ComparableProductMapper comparableProductMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public void addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());

        product.setDescription(productRequest.getDescription());
        product.setSales_Package(productRequest.getSales_Package());
        product.setColor(productRequest.getColor());
        product.setSecondaryMaterial(productRequest.getSecondaryMaterial());
        product.setConfiguration(productRequest.getConfiguration());
        product.setFillingMaterial(productRequest.getFillingMaterial());
        product.setOriginOfManufacture(productRequest.getOriginOfManufacture());
        product.setWidth(productRequest.getWidth());
        product.setHeight(productRequest.getHeight());
        product.setWeight(productRequest.getWeight());
        product.setWarranty_summary(productRequest.getWarranty_summary());
        product.setCovered_in_warranty(productRequest.getCovered_in_warranty());
        product.setNotCoveredInWarranty(productRequest.getNotCoveredInWarranty());
        product.setDomesticWarranty(productRequest.getDomesticWarranty());
        productRepository.save(product);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new NotFoundException("product not found with id:" + id + "!", HttpStatus.BAD_REQUEST);
        return productMapper.toDto(product.get());
    }

    @Override
    public void deleteProductById(Long id) {
        if (productRepository.findById(id).isEmpty())
            throw new NotFoundException("product not found with id:" + id + "!", HttpStatus.BAD_REQUEST);
        productRepository.deleteById(id);
    }


    @Override
    public ProductResponse getProductBySKU(String SKU) {
        Product product = productRepository.findBySKU(SKU);
        if (product == null) {
            throw new NotFoundException("Product not found with SKU: " + SKU + "!", HttpStatus.NOT_FOUND);
        }
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductResponse> all() {
        return productMapper.toDtos(productRepository.findAll());
    }

    @Override
    public void addCategory(CategoryRequest request) {
        Optional<Category> category1 = categoryRepository.findByTitle(request.getName());
        if(category1.isPresent())
            throw new BadRequestException("This category already exists!");
        Category category = new Category();
        category.setName(request.getName());
        categoryRepository.save(category);
    }

    @Override
    public ProductComparisonResponse getComparableProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty())
            throw new NotFoundException("product not found with id:" + id + "!", HttpStatus.BAD_REQUEST);
        return comparableProductMapper.toDto(product.get());

    }

    @Override
    public void updateProductById(Long id, ProductRequest productRequest) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new NotFoundException("product not fount with id " + id + "!", HttpStatus.BAD_REQUEST);
        product.get().setName(productRequest.getName());
        product.get().setDescription(productRequest.getDescription());
        product.get().setPrice(productRequest.getPrice());
        productRepository.save(product.get());
    }}



