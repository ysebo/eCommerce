package com.example.eCommerce.mapper.impl;

import com.example.eCommerce.dto.product.ProductComparisonResponse;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.mapper.ComparableProductMapper;
import org.springframework.stereotype.Component;


@Component
public class ComparableProductMapperImpl implements ComparableProductMapper {


    @Override
    public ProductComparisonResponse toDto(Product product) {
        ProductComparisonResponse productComp = new ProductComparisonResponse();
        productComp.setPrice(product.getPrice());
        productComp.setSales_Package(product.getSales_Package());
        productComp.setColor(product.getColor());
        productComp.setSecondaryMaterial(product.getSecondaryMaterial());
        productComp.setConfiguration(product.getConfiguration());
        productComp.setOriginOfManufacture(product.getOriginOfManufacture());
        productComp.setWidth(product.getWidth());
        productComp.setHeight(product.getHeight());
        productComp.setWeight(product.getWeight());
        productComp.setWarranty_summary(product.getWarranty_summary());
        return productComp;
    }
}
