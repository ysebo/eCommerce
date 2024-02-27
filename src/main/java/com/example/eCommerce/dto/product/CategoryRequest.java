package com.example.eCommerce.dto.product;

import com.example.eCommerce.entities.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

public class CategoryRequest {

    private String name;

}
