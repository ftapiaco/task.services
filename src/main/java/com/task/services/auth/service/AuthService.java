package com.task.services.auth.service;

import com.task.services.auth.dto.AuthRequest;
import com.task.services.auth.dto.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest request);
    String login(AuthRequest request);
}
