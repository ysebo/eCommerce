package com.example.eCommerce.service.user;

import com.example.eCommerce.dto.Payment.PaymentDetailsRegisterRequest;
import com.example.eCommerce.dto.Payment.PaymentDetailsRegisterResponse;

public interface UserService {
    void register(PaymentDetailsRegisterRequest userRequest);
    PaymentDetailsRegisterResponse getById(Long id);
    void deleteById(Long id);
}
