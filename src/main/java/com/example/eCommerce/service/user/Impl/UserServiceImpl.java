package com.example.eCommerce.service.user.Impl;

import com.example.eCommerce.dto.User.UserRegisterRequest;
import com.example.eCommerce.dto.User.UserRegisterResponse;
import com.example.eCommerce.entities.User;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.repositories.UserRepository;
import com.example.eCommerce.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public void register(UserRegisterRequest userRequest) {
        if (userRequest.getEmail().isEmpty())
            throw new NotFoundException("Username can't be empty" , HttpStatus.BAD_GATEWAY);
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setCompanyName(userRequest.getCompanyName());
        user.setCountry(userRequest.getCountry());
        user.setStreetAddress(userRequest.getStreetAddress());
        user.setTownName(userRequest.getTownName());
        user.setProvinceName(userRequest.getProvinceName());
        user.setZipCode(userRequest.getZipCode());
        user.setPhone(userRequest.getPhone());
        user.setEmail(userRequest.getEmail());
        user.setAdditionalInfo(userRequest.getAdditionalInfo());
        userRepository.save(user);
    }

    @Override
    public UserRegisterResponse getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            System.out.println("user is empty!");
        }
        else {
            UserRegisterResponse userResponse = new UserRegisterResponse();
            userResponse.setFirstName(user.get().getFirstName());
            userResponse.setLastName(user.get().getLastName());
            userResponse.setCompanyName(user.get().getCompanyName());
            userResponse.setCountry(user.get().getCountry());
            userResponse.setStreetAddress(user.get().getStreetAddress());
            userResponse.setTownName(user.get().getTownName());
            userResponse.setProvinceName(user.get().getProvinceName());
            userResponse.setZipCode(user.get().getZipCode());
            userResponse.setPhone(user.get().getPhone());
            userResponse.setEmail(user.get().getEmail());
            userResponse.setAdditionalInfo(user.get().getAdditionalInfo());
            return userResponse;

        }
        return null;
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
