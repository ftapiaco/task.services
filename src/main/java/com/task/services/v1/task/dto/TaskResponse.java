package com.task.services.v1.task.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class TaskResponse {
    @Schema(description = "Codigo de la tarea", example = "68678194efffba86cd31bcb7")
    private String id;
    @Schema(description = "Nombre de la tarea", example = "Investigacion")
    private String title;
    @Schema(description = "Descripcion de la tarea", example = "Investigar sobre el uso de Swagger en Spring Boot")
    private String description;
}
