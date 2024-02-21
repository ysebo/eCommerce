package com.example.eCommerce.controller;

import com.example.eCommerce.dto.authLogin.AuthLoginRequest;
import com.example.eCommerce.dto.authLogin.AuthLoginResponse;
import com.example.eCommerce.service.auth.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody AuthLoginRequest authLoginRequest){

        authService.register(authLoginRequest);
        return "User " + authLoginRequest.getEmail() + "registered successfully!";
    }

    @PostMapping("/login")
    public AuthLoginResponse login(AuthLoginRequest authLoginRequest){

        return authService.login(authLoginRequest);
    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable Long id){
        authService.deleteById(id);
        return "User " + id+ "deleted successfully!";
    }

}
