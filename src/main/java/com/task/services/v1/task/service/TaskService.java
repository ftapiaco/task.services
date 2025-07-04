package com.task.services.v1.task.service;


import com.task.services.v1.task.dto.TaskRequest;
import com.task.services.v1.task.dto.TaskResponse;

import java.util.List;

public interface  TaskService {
    List<TaskResponse> getTasks(String userId);
    TaskResponse createTask(String userId, TaskRequest request);
    TaskResponse updateTask(String userId, String taskId, TaskRequest request);
    void deleteTask(String userId, String taskId);
}
