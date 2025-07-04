package com.task.services.v1.task.mapper;

import com.task.services.v1.task.domain.Task;
import com.task.services.v1.task.dto.TaskRequest;
import com.task.services.v1.task.dto.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TaskMapper
{
    public Task toTask(TaskRequest taskRequest, String email) {
        Task task = new Task();

        task.setEmail(email);
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        return task;
    }
    public TaskResponse toTaskResponse(Task task) {
        TaskResponse taskRequest = new TaskResponse();
        taskRequest.setId(task.getId());
        taskRequest.setTitle(task.getTitle());
        taskRequest.setDescription(task.getDescription());
        return taskRequest;
    }
}
