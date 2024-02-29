package com.example.eCommerce.repositories;

import com.example.eCommerce.entities.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
    Optional<OrderHistoryRepository> findByEmail(String email);
}
