package org.example.taskservice.services.implementations;

import org.example.taskservice.domain.models.Person;
import org.example.taskservice.domain.models.Task;
import org.example.taskservice.repositories.PersonRepo;
import org.example.taskservice.repositories.TaskRepo;
import org.example.taskservice.services.TaskService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;


@Service

public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;

    private final PersonRepo personRepo;

    public TaskServiceImpl(TaskRepo taskRepo, PersonRepo personRepo) {
        this.taskRepo = taskRepo;
        this.personRepo = personRepo;
    }

    public List<Task> findAllTask() {
        return taskRepo.findAllTask();
    }


    public void save(Task task) {
        Person author =
                personRepo.findByEmail(
                        task.getAuthor().getEmail()).orElseThrow(IllegalArgumentException::new);
        Person performer =
                personRepo.findByEmail(
                        task.getPerformer().getEmail()).orElseThrow(IllegalArgumentException::new);
        task.setAuthor(author);
        task.setPerformer(performer);
        task.setCreationDate(LocalDateTime.now());
        taskRepo.save(task);
    }

    public Task findById(long id) {
        return taskRepo.findById(id).orElseThrow(IllegalArgumentException::new);
    }


    public void delete(long id) {
        taskRepo.deleteById(id);
    }

    public List<Task> findByAuthorId(long id) {
        return taskRepo.findByAuthorId(id);
    }

    public List<Task> findByPerformerId(long id) {
        return taskRepo.findByPerformerId(id);
    }

}
