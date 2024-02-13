package com.example.eCommerce.service.user.Impl;

import com.example.eCommerce.dto.Payment.PaymentDetailsRegisterRequest;
import com.example.eCommerce.dto.Payment.PaymentDetailsRegisterResponse;
import com.example.eCommerce.dto.User.UserRequest;
import com.example.eCommerce.entities.User;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.mapper.UserMapper;
import com.example.eCommerce.repositories.UserRepository;
import com.example.eCommerce.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public void register(UserRequest userRequest) {
        if (userRequest.getEmail().isEmpty())
            throw new NotFoundException("Username can't be empty" , HttpStatus.BAD_GATEWAY);
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);
    }

    @Override
    public PaymentDetailsRegisterResponse getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new NotFoundException("user not found with id:"+id+"!", HttpStatus.BAD_REQUEST);
        return userMapper.toDto(user.get());
    }

    @Override
    public void deleteById(Long id) {

        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            System.out.println("user is empty!");
        }
        else {
            userRepository.deleteById(id);
        }
    }
}
