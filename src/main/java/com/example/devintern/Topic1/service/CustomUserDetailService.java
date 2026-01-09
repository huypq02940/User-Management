package com.example.devintern.Topic1.service;

import com.example.devintern.Topic1.entity.User;
import com.example.devintern.Topic1.exception.CustomResourceNotFoundException;
import com.example.devintern.Topic1.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username).orElseThrow(() -> new CustomResourceNotFoundException("User not found"));
        if(!Boolean.TRUE.equals(user.getActive())){
            throw new CustomResourceNotFoundException("User is not active");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().getName())
                .build();
    }
}