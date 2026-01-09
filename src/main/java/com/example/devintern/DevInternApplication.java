package com.example.devintern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DevInternApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevInternApplication.class, args);
//        String password = new BCryptPasswordEncoder().encode("123456");
//        System.out.println(password);
    }

}
