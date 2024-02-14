package com.example.eCommerce.service.auth;

import com.example.eCommerce.dto.AuthLogin.AuthLoginRequest;
import com.example.eCommerce.dto.AuthLogin.AuthLoginResponse;
import com.example.eCommerce.dto.Payment.PaymentDetailsRegisterRequest;
import com.example.eCommerce.entities.User;

public interface AuthService {
    void register(AuthLoginRequest authLoginRequest);

    AuthLoginResponse login(AuthLoginRequest authLoginRequest);
    User getUsernameFromToken(String token);
}
