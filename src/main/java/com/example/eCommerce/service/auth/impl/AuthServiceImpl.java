package com.example.eCommerce.service.auth.impl;

import com.example.eCommerce.config.JwtService;
import com.example.eCommerce.dto.authLogin.AuthLoginRequest;
import com.example.eCommerce.dto.authLogin.AuthLoginResponse;
import com.example.eCommerce.entities.User;
import com.example.eCommerce.exception.BadCredentialsException;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.repositories.UserRepository;
import com.example.eCommerce.service.auth.AuthService;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Override
    public void register(AuthLoginRequest authLoginRequest) {
        if (userRepository.findByEmail(authLoginRequest.getEmail()).isPresent())
            throw new BadCredentialsException("user with email: "+authLoginRequest.getEmail()+" is already exist!");
        User user = new User();
        user.setEmail(authLoginRequest.getEmail());
        user.setPassword(encoder.encode(authLoginRequest.getPassword()));
        userRepository.save(user);
    }

    @Override
    public AuthLoginResponse login(AuthLoginRequest authLoginRequest) {
        Optional<User> user = userRepository.findByEmail(authLoginRequest.getEmail());
        if(user.isEmpty())
            throw new BadCredentialsException("user not found");
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authLoginRequest.getEmail(),authLoginRequest.getPassword()));

        }catch (org.springframework.security.authentication.BadCredentialsException e){
            throw new BadCredentialsException("user not found");
        }
        return convertToResponse(user);
    }

    @Override
    public User getUsernameFromToken(String token) {
        String[] chunks = token.substring(7).split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();

        JSONParser jsonParser = new JSONParser();
        JSONObject object = null;
        try {
            object = (JSONObject) jsonParser.parse(decoder.decode(chunks[1]));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return userRepository.findByEmail(String.valueOf(object.get("sub"))).orElseThrow(() -> new RuntimeException("user can be null"));
    }

    @Override
    public void deleteById(Long id) {
        if(userRepository.findById(id).isEmpty())
            throw new NotFoundException("user not found with id:" + id + "!", HttpStatus.BAD_REQUEST);
        userRepository.deleteById(id);
    }


    public AuthLoginResponse convertToResponse(Optional<User> user){
        AuthLoginResponse authLoginResponse = new AuthLoginResponse();
        authLoginResponse.setEmail(user.get().getEmail());
        authLoginResponse.setId(user.get().getId());
        Map<String, Object> extraClaims = new HashMap<>();

        String token = jwtService.generateToken(extraClaims, user.get());
        authLoginResponse.setToken(token);

        return authLoginResponse;
    }
}
