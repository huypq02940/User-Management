package com.example.devintern.Topic1.service.impl;

import com.example.devintern.Topic1.dto.UserRequest;
import com.example.devintern.Topic1.dto.UserResponse;
import com.example.devintern.Topic1.entity.Role;
import com.example.devintern.Topic1.entity.User;
import com.example.devintern.Topic1.exception.CustomResourceNotFoundException;
import com.example.devintern.Topic1.repository.RoleRepo;
import com.example.devintern.Topic1.repository.UserRepo;
import com.example.devintern.Topic1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepo.findAll().stream().map(user -> modelMapper.map(user, UserResponse.class)).toList();
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        if (userRepo.existsByUsername(userRequest.getUsername())) {
            throw new CustomResourceNotFoundException("Ten" + userRequest.getUsername() + "da ton tai");
        }
        Role role = roleRepo.findById(userRequest.getRoleId()).orElseThrow(() -> new CustomResourceNotFoundException("Vai tro " + userRequest.getRoleId() + "khong tim thay"));
        User user = modelMapper.map(userRequest, User.class);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword())); //Mã hóa mật khẩu bcrypt về định dạng thường
        user.setRole(role);
        User savedUser = userRepo.save(user);
        return modelMapper.map(savedUser, UserResponse.class);
    }
}
