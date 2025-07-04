package com.task.services.v1.task.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskRequest {

    @NotBlank(message = "El título no puede estar vacío.")
    @Size(max = 255, message = "El título debe tener máximo 255 caracteres.")
    @Schema(description = "Nombre de la tarea", example = "Investigacion", required = true)
    private String title;

    @Size(max = 500, message = "La descripción debe tener máximo 500 caracteres.")
    @Schema(description = "Descripcion de la tarea", example = "Investigacion de la vida.", required = true)
    private String description;

}
