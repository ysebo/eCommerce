package com.example.eCommerce.service;

import com.example.eCommerce.dto.AuthLogin.AuthLoginRequest;
import com.example.eCommerce.dto.User.UserRegisterRequest;
import org.springframework.stereotype.Service;

public interface AuthService {
    void register(UserRegisterRequest userRegisterRequest);

    void login(AuthLoginRequest authLoginRequest);
}
