package com.example.eCommerce.service.auth;

import com.example.eCommerce.dto.authLogin.AuthLoginRequest;
import com.example.eCommerce.dto.authLogin.AuthLoginResponse;
import com.example.eCommerce.entities.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public interface AuthService {
    AuthLoginResponse register(AuthLoginRequest authLoginRequest);

    AuthLoginResponse login(AuthLoginRequest authLoginRequest);
    User getUsernameFromToken(String token);

    void deleteById(Long id);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
