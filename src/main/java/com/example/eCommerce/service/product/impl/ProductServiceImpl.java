package com.example.eCommerce.service.product.impl;

import com.example.eCommerce.dto.restock.RestockRequest;
import com.example.eCommerce.dto.product.CategoryRequest;
import com.example.eCommerce.dto.product.ProductComparisonResponse;
import com.example.eCommerce.dto.product.ProductRequest;
import com.example.eCommerce.dto.product.ProductResponse;
import com.example.eCommerce.dto.restock.RestockRequest;
import com.example.eCommerce.entities.*;
import com.example.eCommerce.exception.BadRequestException;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.mapper.ComparableProductMapper;
import com.example.eCommerce.mapper.ProductMapper;
import com.example.eCommerce.repositories.*;


import com.example.eCommerce.service.auth.AuthService;
import com.example.eCommerce.service.image.ImageService;
import com.example.eCommerce.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ComparableProductMapper comparableProductMapper;
    private final CategoryRepository categoryRepository;
    private final AuthService authService;
    private final OrderHistoryRepository orderHistoryRepository;
    private final CartItemRepository cartItemRepository;
    private final ImageService imageService;
    private final ImageRepository imageRepository;


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
        product.setOriginOfManufacture(productRequest.getOriginOfManufacture());
        product.setWidth(productRequest.getWidth());
        product.setHeight(productRequest.getHeight());
        product.setWeight(productRequest.getWeight());
        product.setWarranty_summary(productRequest.getWarranty_summary());
        product.setQuantity(productRequest.getQuantity());
        if(productRequest.getQuantity().equals(0)){
            product.setExist(Boolean.FALSE);
        }
        else{
            product.setExist(Boolean.TRUE);
        }


        productRepository.save(product);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new NotFoundException("product not found with id:" + id + "!", HttpStatus.NOT_FOUND);
        return productMapper.toDto(product.get());
    }

    @Override
    public void deleteProductById(Long id) {
        if (productRepository.findById(id).isEmpty())
            throw new NotFoundException("product not found with id:" + id + "!", HttpStatus.NOT_FOUND);
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
        Optional<Category> category1 = categoryRepository.findByName(request.getName());
        if(category1.isPresent())
            throw new BadRequestException("This category already exists!");
        Category category = new Category();
        category.setName(request.getName());
        categoryRepository.save(category);
    }

    @Override
    public List<ProductComparisonResponse> getComparableProduct(Long id ,  Long id2) {
        Optional<Product> product = productRepository.findById(id);
        Optional<Product>product1= productRepository.findById(id);

        if(product.isEmpty())
            throw new NotFoundException("product not found with id:" + id + "!" , HttpStatus.NOT_FOUND);
        if(product1.isEmpty())
            throw new NotFoundException("product not found with id:" + id + "!", HttpStatus.NOT_FOUND);
        return (List<ProductComparisonResponse>) comparableProductMapper.toDto(product.get() , product1.get());

    }



    @Override
    public void restockProduct(Long id, RestockRequest restockRequest) {
        Optional<Product > product = productRepository.findById(id);
        Integer remainder = product.get().getQuantity();
        if(product.isEmpty()){
            throw new NotFoundException("Product with this id:" + id +" wasn't found ", HttpStatus.NOT_FOUND);
        }
        product.get().setQuantity(restockRequest.getQuantity()+remainder);
        product.get().setExist(Boolean.TRUE);
        productRepository.save(product.get());
    }

    @Override
    public void uploadFile(String token, MultipartFile file, Long productId) {
        User user = authService.getUsernameFromToken(token);
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new NotFoundException("product with id " + productId+ " was not found ", HttpStatus.NOT_FOUND));
        if(user != product.getUser())
            throw new BadRequestException("You can't edit this product!");
        Image save;
        List<OrderHistory> orders = null;
        List<CartItem> items = null;
        if(product.getImage() != null){
            Image image = product.getImage();
            items = image.getItems();
            orders = image.getOrders();
            save = imageService.uploadFile(file, image);
            if(items != null){
                List<CartItem> itemList = new ArrayList<>();
                for(CartItem item: items){
                    item.setImage(save);
                    itemList.add(item);
                    cartItemRepository.save(item);
                }
                save.setItems(itemList);
            }
            if(orders != null){
                List<OrderHistory> orderList = new ArrayList<>();
                for(OrderHistory order: orders){
                    order.setImage(save);
                    orderList.add(order);
                    orderHistoryRepository.save(order);
                }
                save.setOrders(orderList);
            }
        } else save = imageService.uploadFile(file);

        product.setImage(save);
        productRepository.save(product);
        save.setProduct(product);
        imageRepository.save(save);
    }


    @Override
    public void updateProductById(Long id, ProductRequest productRequest) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new NotFoundException("product not fount with id " + id + "!", HttpStatus.NOT_FOUND);
        product.get().setName(productRequest.getName());
        product.get().setDescription(productRequest.getDescription());
        product.get().setPrice(productRequest.getPrice());
        product.get().setSales_Package(productRequest.getSales_Package());
        product.get().setColor(productRequest.getColor());
        product.get().setSecondaryMaterial(productRequest.getSecondaryMaterial());
        product.get().setConfiguration(productRequest.getConfiguration());
        product.get().setOriginOfManufacture(productRequest.getOriginOfManufacture());
        product.get().setWidth(productRequest.getWidth());
        product.get().setHeight(productRequest.getHeight());
        product.get().setWeight(productRequest.getWeight());
        product.get().setWarranty_summary(productRequest.getWarranty_summary());
        product.get().setQuantity(productRequest.getQuantity());
        productRepository.save(product.get());
    }
}



