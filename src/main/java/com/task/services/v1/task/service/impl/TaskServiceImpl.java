package com.task.services.v1.task.service.impl;


import com.task.services.exception.exceptions.GenericException;
import com.task.services.exception.exceptions.ResourceNotFoundException;
import com.task.services.v1.task.domain.Task;
import com.task.services.v1.task.dto.TaskRequest;
import com.task.services.v1.task.dto.TaskResponse;
import com.task.services.v1.task.mapper.TaskMapper;
import com.task.services.v1.task.repository.TaskRepository;
import com.task.services.v1.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    @Override
    public TaskResponse createTask(String email, TaskRequest request) {
        Task task = taskMapper.toTask(request, email);
        taskRepository.save(task);

        return taskMapper.toTaskResponse(task);
    }

    @Override
    public List<TaskResponse> getTasks(String userId) {
        List<Task> tasks = taskRepository.findByEmail(userId);

        return tasks.stream()
                .map(task -> taskMapper.toTaskResponse(task))
                .toList() ;
    }

    @Override
    public TaskResponse updateTask(String userId, String taskId, TaskRequest request) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada."));

        if (!task.getEmail().equals(userId)) {
            throw new RuntimeException("No tienes permisos para actualizar esta tarea.");
        }

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());

        taskRepository.save(task);

        return taskMapper.toTaskResponse(task);
    }

    @Override
    public void deleteTask(String userId, String taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada."));

        if (!task.getEmail().equals(userId)) {
            throw new GenericException("No tienes permisos para eliminar esta tarea.");
        }

        taskRepository.delete(task);
    }
}
