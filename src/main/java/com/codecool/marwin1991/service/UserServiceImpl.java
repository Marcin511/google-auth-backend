package com.codecool.marwin1991.service;

import com.codecool.marwin1991.exception.ResourceNotFoundException;
import com.codecool.marwin1991.repository.UserRepository;
import com.codecool.marwin1991.security.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return UserPrincipal.create(repository.findByEmail(email)
                .orElseThrow(()->new NoSuchElementException("user not exist")));
    }

    @Override
    public UserDetails loadUserById(String id) {
        return UserPrincipal.create(repository.findById(id)
                .orElseThrow(()->new NoSuchElementException("user not exist")));
    }
}
