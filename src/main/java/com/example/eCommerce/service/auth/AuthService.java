package com.example.eCommerce.service.auth;

import com.example.eCommerce.dto.AuthLogin.AuthLoginRequest;
import com.example.eCommerce.dto.AuthLogin.AuthLoginResponse;
import com.example.eCommerce.dto.Payment.PaymentDetailsRegisterRequest;

public interface AuthService {
    void register(PaymentDetailsRegisterRequest userRegisterRequest);

    AuthLoginResponse login(AuthLoginRequest authLoginRequest);
}
