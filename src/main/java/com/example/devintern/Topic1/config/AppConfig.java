package com.example.devintern.Topic1.config;

import com.example.devintern.Topic1.dto.UserRequest;
import com.example.devintern.Topic1.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {
    @Bean
    ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(UserRequest.class, User.class)
                .addMappings(m -> m.skip(User::setId));
        return mapper;
    }
}
