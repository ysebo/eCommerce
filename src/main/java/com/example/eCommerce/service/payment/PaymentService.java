package com.example.eCommerce.service.payment;

import com.example.eCommerce.dto.Payment.PaymentDetailsRegisterRequest;
import com.example.eCommerce.dto.Payment.PaymentDetailsRegisterResponse;


public interface PaymentService {
    void register(PaymentDetailsRegisterRequest userRequest);
    PaymentDetailsRegisterResponse getById(Long id);
    void deleteById(Long id);
}
