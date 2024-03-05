package com.example.eCommerce.service.payment;

import com.example.eCommerce.dto.payment.PaymentDetailsRegisterRequest;
import com.example.eCommerce.dto.payment.PaymentDetailsRegisterResponse;
import com.example.eCommerce.dto.product.ProductResponse;

import java.time.LocalDate;


public interface PaymentService {
    void register(PaymentDetailsRegisterRequest userRequest);
    PaymentDetailsRegisterResponse getById(Long id);
    void deleteById(Long id);
}
