package com.example.eCommerce.dto.authLogin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthTokenResponse {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
}
