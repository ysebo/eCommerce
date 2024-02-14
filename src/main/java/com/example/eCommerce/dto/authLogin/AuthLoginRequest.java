package com.example.eCommerce.dto.authLogin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthLoginRequest {
    private String email;
    private String password;
}
