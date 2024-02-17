package com.example.eCommerce.repositories;

import com.example.eCommerce.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepostitory extends JpaRepository<Cart, Long> {



}
