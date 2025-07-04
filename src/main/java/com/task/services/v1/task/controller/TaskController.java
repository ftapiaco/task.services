package com.task.services.v1.task.controller;

import com.task.services.auth.config.JwtUtil;
import com.task.services.config.utils.Util;
import com.task.services.v1.task.dto.TaskRequest;
import com.task.services.v1.task.dto.TaskResponse;
import com.task.services.v1.task.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final JwtUtil jwtUtil;
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    @PostMapping
    @Operation(summary = "Crea Tarea", description = "Retorna la tarea creada")
    @ApiResponse(responseCode = "201", description = "Tarea creada correctamente")
    public ResponseEntity<TaskResponse> createTask(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
            @RequestBody @Valid TaskRequest request) {
        logger.info(Util.toJsonString(request));
        String email = jwtUtil.extractUserId(authHeader.substring(7));
        logger.info(email);
        TaskResponse response = taskService.createTask(email, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @Operation(summary = "Lista Tareas", description = "Retorna la lista de tareas del usuario autenticado")
    @ApiResponse(responseCode = "200", description = "Tarea listada correctamente")
    public ResponseEntity<List<TaskResponse>> getTasks(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {

        String userId = jwtUtil.extractUserId(authHeader.substring(7));
        return ResponseEntity.ok(taskService.getTasks(userId));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza Tareas", description = "Actualiza la tarea del usuario autenticado")
    @ApiResponse(responseCode = "200", description = "Tarea Actualizada correctamente")
    public ResponseEntity<TaskResponse> updateTask(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
            @PathVariable String id,
            @RequestBody @Valid TaskRequest request) {

        String userId = jwtUtil.extractUserId(authHeader.substring(7));
        TaskResponse response = taskService.updateTask(userId, id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina Tarea", description = "Elimina la tarea del usuario autenticado")
    @ApiResponse(responseCode = "204", description = "Tarea eliminada correctamente")
    public ResponseEntity<Void> deleteTask(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
            @PathVariable String id) {

        String userId = jwtUtil.extractUserId(authHeader.substring(7));
        taskService.deleteTask(userId, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
