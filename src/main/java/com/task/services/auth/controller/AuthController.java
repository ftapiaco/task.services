package com.task.services.auth.controller;

import com.task.services.auth.dto.AuthRequest;
import com.task.services.auth.dto.AuthResponse;
import com.task.services.auth.dto.RegisterRequest;
import com.task.services.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "Crea usuario", description = "Crea un nuevo usuario para la autenticación")
    @ApiResponse(responseCode = "200", description = "Creación de usuario exitosa")
    public Mono<ResponseEntity<String>> register(@Valid @RequestBody RegisterRequest request) {
        authService.register(request);
        return Mono.just( ResponseEntity.ok("Usuario registrado exitosamente."));
    }

    @PostMapping("/login")
    @Operation(summary = "Autenticacion de usuario", description = "Autentica un usuario y genera un token JWT si las credenciales son válidas.")
    @ApiResponse(responseCode = "200", description = "Autenticación exitosa. Token JWT generado.")
    public Mono<ResponseEntity<AuthResponse>> login(@Valid @RequestBody AuthRequest request) {
        return  Mono.just( ResponseEntity.ok(new AuthResponse(authService.login(request))));
    }

}
