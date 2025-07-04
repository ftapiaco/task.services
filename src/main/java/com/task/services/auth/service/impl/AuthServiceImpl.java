package com.task.services.auth.service.impl;

import com.task.services.auth.config.JwtUtil;
import com.task.services.auth.domain.User;
import com.task.services.auth.dto.AuthRequest;
import com.task.services.auth.dto.RegisterRequest;
import com.task.services.auth.mapper.AuthMapper;
import com.task.services.auth.repository.UserRepository;
import com.task.services.auth.service.AuthService;
import com.task.services.exception.exceptions.GenericException;
import com.task.services.exception.exceptions.ResourceNotFoundException;
import com.task.services.exception.exceptions.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthMapper authMapper;
    @Override
    public void register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new GenericException("El email ya está registrado.");
        }

        User user = authMapper.toUser(request);
        userRepository.save(user);
    }

    @Override
    public String login(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Email no encontrado."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("Credenciales inválidas.");
        }

        return jwtUtil.generateToken(user.getId());
    }
}
