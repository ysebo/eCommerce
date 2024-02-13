package com.example.eCommerce.repositories;

import com.example.eCommerce.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByEmail(String username);
}
