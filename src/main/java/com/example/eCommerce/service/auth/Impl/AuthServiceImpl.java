package com.example.eCommerce.service.auth.Impl;

import com.example.eCommerce.dto.Payment.PaymentDetailsRegisterRequest;
import com.example.eCommerce.config.JwtService;
import com.example.eCommerce.dto.AuthLogin.AuthLoginRequest;
import com.example.eCommerce.dto.AuthLogin.AuthLoginResponse;
import com.example.eCommerce.entities.User;
import com.example.eCommerce.exception.BadCredentialsException;
import com.example.eCommerce.repositories.UserRepository;
import com.example.eCommerce.service.auth.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Override
    public void register(PaymentDetailsRegisterRequest userRegisterRequest) {
        if (userRepository.findByEmail(userRegisterRequest.getEmail()).isPresent())
            throw new BadCredentialsException("user with email: "+userRegisterRequest.getEmail()+" is already exist!");
        User user = new User();

    }

    @Override
    public AuthLoginResponse login(AuthLoginRequest authLoginRequest) {
        return null;
    }
}
