package com.example.devintern.Topic1.service;

import com.example.devintern.Topic1.dto.UserRequest;
import com.example.devintern.Topic1.dto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();
    UserResponse addUser(UserRequest userRequest);
}
