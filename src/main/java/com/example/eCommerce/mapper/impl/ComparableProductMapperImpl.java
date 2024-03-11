package com.example.eCommerce.mapper.impl;

import com.example.eCommerce.dto.product.ProductComparisonResponse;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.mapper.ComparableProductMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ComparableProductMapperImpl implements ComparableProductMapper {


    @Override
    public List<ProductComparisonResponse> toDto(Product product ,Product product1) {
        List<ProductComparisonResponse> productComps = new ArrayList<>();

        ProductComparisonResponse productComp = new ProductComparisonResponse();
        productComp.setName(product.getName());
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
        productComps.add(productComp);

        ProductComparisonResponse productComp2 = new ProductComparisonResponse();
        productComp2.setName(product1.getName());
        productComp2.setPrice(product1.getPrice());
        productComp2.setSales_Package(product1.getSales_Package());
        productComp2.setColor(product1.getColor());
        productComp2.setSecondaryMaterial(product1.getSecondaryMaterial());
        productComp2.setConfiguration(product1.getConfiguration());
        productComp2.setOriginOfManufacture(product1.getOriginOfManufacture());
        productComp2.setWidth(product1.getWidth());
        productComp2.setHeight(product1.getHeight());
        productComp2.setWeight(product1.getWeight());
        productComp2.setWarranty_summary(product1.getWarranty_summary());
        productComps.add(productComp2);

        return productComps;

    }
}
