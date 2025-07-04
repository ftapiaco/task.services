package com.task.services.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Request para el registro de un nuevo email")

public class RegisterRequest {
    @Schema(description = "Email", example = "fer@gmail.com", required = true)
    private String email;
    @Schema(description = "Contraseña", example = "pass", required = true)
    private String password;
}
