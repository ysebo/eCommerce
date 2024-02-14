package com.example.eCommerce.mapper;

import com.example.eCommerce.dto.payment.PaymentDetailsRegisterResponse;
import com.example.eCommerce.entities.User;

public interface UserMapper {
    PaymentDetailsRegisterResponse toDto(User user);
}
