package com.task.services.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    @Schema(description = "Email", example = "fer@gmail.com", required = true)
    private String email;
    @Schema(description = "contraseña del correo", example = "pass", required = true)
    private String password;
}
