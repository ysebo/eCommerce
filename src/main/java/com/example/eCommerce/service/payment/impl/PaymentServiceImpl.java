package com.example.eCommerce.service.payment.impl;

import com.example.eCommerce.dto.payment.PaymentDetailsRegisterRequest;
import com.example.eCommerce.dto.payment.PaymentDetailsRegisterResponse;
import com.example.eCommerce.entities.Payment;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.repositories.PaymentRepository;
import com.example.eCommerce.service.payment.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    @Override
    public void register(PaymentDetailsRegisterRequest userRequest) {
        if(userRequest.getEmail().isEmpty())
            throw new NotFoundException("Email can't be empty", HttpStatus.BAD_GATEWAY);
        Payment payment = new Payment();
        payment.setZipCode(userRequest.getZipCode());
        payment.setTownName(userRequest.getTownName());
        payment.setStreetAddress(userRequest.getStreetAddress());
        payment.setPhone(userRequest.getPhone());
        payment.setCompanyName(userRequest.getCompanyName());
        payment.setEmail(userRequest.getEmail());
        payment.setAdditionalInfo(userRequest.getAdditionalInfo());
        payment.setZipCode(userRequest.getZipCode());
        payment.setProvinceName(userRequest.getProvinceName());
        payment.setFirstName(userRequest.getFirstName());
        payment.setLastName(userRequest.getLastName());
        payment.setCountry(userRequest.getCountry());
        paymentRepository.save(payment);
    }

    @Override
    public PaymentDetailsRegisterResponse getById(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if(payment.isEmpty()){
            System.out.println("payment is empty!");
        }
        else{
            PaymentDetailsRegisterResponse paymentDetailsRegisterResponse = new PaymentDetailsRegisterResponse();
            paymentDetailsRegisterResponse.setEmail(payment.get().getEmail());
            paymentDetailsRegisterResponse.setPhone(payment.get().getPhone());
            paymentDetailsRegisterResponse.setFirstName(payment.get().getFirstName());
            paymentDetailsRegisterResponse.setCountry(payment.get().getCountry());
            paymentDetailsRegisterResponse.setAdditionalInfo(payment.get().getAdditionalInfo());
            paymentDetailsRegisterResponse.setCompanyName(payment.get().getCompanyName());
            paymentDetailsRegisterResponse.setZipCode(payment.get().getZipCode());
            paymentDetailsRegisterResponse.setTownName(payment.get().getTownName());
            paymentDetailsRegisterResponse.setStreetAddress(payment.get().getStreetAddress());
            paymentDetailsRegisterResponse.setLastName(payment.get().getLastName());
            paymentDetailsRegisterResponse.setProvinceName(payment.get().getProvinceName());
            return paymentDetailsRegisterResponse;

        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if(payment.isEmpty()){
            System.out.println("payment is empty ");
        }
        else {
            paymentRepository.deleteById(id);
        }
    }
}
