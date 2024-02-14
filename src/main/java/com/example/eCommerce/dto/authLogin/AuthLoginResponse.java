package com.example.eCommerce.dto.authLogin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthLoginResponse {
    private Long id;
    private String email;
    private String token;
}
