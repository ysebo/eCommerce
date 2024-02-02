package com.example.eCommerce.service.Impl;

import com.example.eCommerce.dto.AuthLogin.AuthLoginRequest;
import com.example.eCommerce.dto.AuthLogin.AuthLoginResponse;
import com.example.eCommerce.dto.User.UserRegisterRequest;
import com.example.eCommerce.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Override
    public void register(UserRegisterRequest userRegisterRequest) {


    }

    @Override
    public AuthLoginResponse login(AuthLoginRequest authLoginRequest) {
        return null;
    }
}
