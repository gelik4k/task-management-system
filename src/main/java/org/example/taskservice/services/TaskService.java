package org.example.taskservice.services;

import org.example.taskservice.domain.models.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTask();

    void save(Task task);

    Task findById(long id);

    void delete(long id);

    List<Task> findByAuthorId(long id);

    List<Task> findByPerformerId(long id);
}
