package com.task.services.v1.task.repository;

import com.task.services.v1.task.domain.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    Optional<Task> findByEmailAndTitle(String email, String title);
    List<Task> findByEmail(String email);
}
