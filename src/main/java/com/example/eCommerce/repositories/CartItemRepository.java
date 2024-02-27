package com.example.eCommerce.repositories;

import com.example.eCommerce.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem , Long> {

    Optional<CartItem> findByName(String name);
    Optional<CartItem> findBySKU(String SKU);

}
