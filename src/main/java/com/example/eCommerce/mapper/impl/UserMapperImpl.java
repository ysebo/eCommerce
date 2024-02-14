package com.example.eCommerce.mapper.impl;

import com.example.eCommerce.dto.payment.PaymentDetailsRegisterResponse;
import com.example.eCommerce.entities.User;
import com.example.eCommerce.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public PaymentDetailsRegisterResponse toDto(User user) {
        PaymentDetailsRegisterResponse userRegisterResponse = new PaymentDetailsRegisterResponse();

        return userRegisterResponse;




    }
}
