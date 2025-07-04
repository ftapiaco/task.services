package com.task.services.auth.mapper;

import com.task.services.auth.domain.User;
import com.task.services.auth.dto.RegisterRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthMapper {
    private final PasswordEncoder passwordEncoder;

    public User toUser(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return user;
    }
}
