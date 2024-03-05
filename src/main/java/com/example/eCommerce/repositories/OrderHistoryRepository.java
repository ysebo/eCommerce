package com.example.eCommerce.repositories;

import com.example.eCommerce.entities.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {

}
