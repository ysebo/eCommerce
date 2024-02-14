package com.example.eCommerce.dto.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDetailsRegisterRequest {
    private String firstName;
    private String lastName;
    private String companyName;
    private String country;
    private String streetAddress;
    private String townName;
    private String provinceName;
    private Integer ZipCode;
    private Integer phone;
    private String email;
    private String additionalInfo;
}
