package com.example.eCommerce.service.user;

import com.example.eCommerce.dto.Payment.PaymentDetailsRegisterRequest;
import com.example.eCommerce.dto.Payment.PaymentDetailsRegisterResponse;
import com.example.eCommerce.dto.User.UserRequest;

public interface UserService {
    void register(UserRequest userRequest);
    PaymentDetailsRegisterResponse getById(Long id);
    void deleteById(Long id);
}
