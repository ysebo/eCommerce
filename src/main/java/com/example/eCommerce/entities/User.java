package com.example.eCommerce.entities;

import com.example.eCommerce.token.Token;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "user_table")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @OneToMany
    private List<Review> reviews;
    @OneToMany
    private List<Product> products;
    @OneToOne
    private Cart cart;
    @OneToMany
    private List<Product> favorites;
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;
    @OneToMany
    private List<OrderHistory>orderHistories;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
