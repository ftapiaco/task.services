package com.task.services.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Respuesta con el token JWT generado al autenticarse correctamente")

public class AuthResponse {
    @Schema(description = "Token JWT generado para el email autenticado", example = "eyJhbGciOiJIUzI1NiJ9...")
    private String token;
}
