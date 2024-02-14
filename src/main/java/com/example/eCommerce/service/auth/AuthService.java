package com.example.eCommerce.service.auth;

import com.example.eCommerce.dto.authLogin.AuthLoginRequest;
import com.example.eCommerce.dto.authLogin.AuthLoginResponse;
import com.example.eCommerce.entities.User;

public interface AuthService {
    void register(AuthLoginRequest authLoginRequest);

    AuthLoginResponse login(AuthLoginRequest authLoginRequest);
    User getUsernameFromToken(String token);

    void deleteById(Long id);
}
