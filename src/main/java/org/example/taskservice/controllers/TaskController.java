package org.example.taskservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.taskservice.domain.dto.CommentReqDto;
import org.example.taskservice.domain.dto.TaskReqDto;
import org.example.taskservice.domain.dto.TaskResDto;
import org.example.taskservice.domain.mappers.CommentMapper;
import org.example.taskservice.domain.mappers.TaskMapper;
import org.example.taskservice.domain.models.Comment;
import org.example.taskservice.domain.models.Task;
import org.example.taskservice.services.CommentService;
import org.example.taskservice.services.PersonService;
import org.example.taskservice.services.TaskService;
import org.example.taskservice.services.implementations.CommentServiceImpl;
import org.example.taskservice.services.implementations.PersonServiceImpl;
import org.example.taskservice.services.implementations.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Tag(name = "TaskController", description = "Контроллер предоставляющий эндпоинты для взаимодействие с записями Task")
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    private final PersonService personService;

    private final CommentService commentService;


    @Autowired
    public TaskController(TaskServiceImpl taskService, PersonServiceImpl personService, CommentServiceImpl commentService) {
        this.taskService = taskService;
        this.personService = personService;
        this.commentService = commentService;
    }

    @Operation(
            summary = "Получение всех записей",
            description = "Позволяет получить все записи из БД"
    )

    @GetMapping
    public ResponseEntity<List<TaskResDto>> tasks() {
        List<TaskResDto> taskResDtos = taskService.findAllTask()
                .stream()
                .map(task -> TaskMapper.toDto(task))
                .collect(Collectors.toList());
        return new ResponseEntity<>(taskResDtos, HttpStatus.OK);


    }

    @Operation(
            summary = "Получение всех задач по id автора",
            description = "Позволяет получить все задачи по id автора"
    )

    @GetMapping("/author/{id}")
    public ResponseEntity<List<TaskResDto>> tasksByAuthorId(@PathVariable("id") long id) {
        List<TaskResDto> tasks = taskService.findByAuthorId(id)
                .stream()
                .map(TaskMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @Operation(
            summary = "Получение всех задач по id исполнителя",
            description = "Позволяет получить все задачи по id исполнителя"
    )

    @GetMapping("/performer/{id}")
    public ResponseEntity<List<TaskResDto>> tasksByPerformerId(@PathVariable("id") long id) {
        List<TaskResDto> tasks = taskService.findByPerformerId(id)
                .stream()
                .map(TaskMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @Operation(
            summary = "Создание новой задачи",
            description = "Позволяет создать новую задачу"
    )

    @PostMapping
    public ResponseEntity<HttpStatus> createTask(@Valid @RequestBody TaskReqDto taskReqDto) {
        Task task = TaskMapper.toEntity(taskReqDto);
        taskService.save(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(
            summary = "Получение задачи по ее id",
            description = "Позволяет получить задачу по ее id"
    )

    @GetMapping("/{id}")
    public ResponseEntity<TaskResDto> getTask(@PathVariable("id") long id) {
        Task task = taskService.findById(id);
        TaskResDto taskOutputDto = TaskMapper.toDto(task);
        return new ResponseEntity<>(taskOutputDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Удаление задачи по ее id",
            description = "Позволяет удалить задачу по ее id"
    )

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable("id") long id) {

        taskService.findById(id);
        taskService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Operation(
            summary = "Изменение задачи по ее id",
            description = "Позволяет изменить задачу по ее id"
    )

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> changeTask(@PathVariable("id") long id,
                                                 @Valid @RequestBody TaskReqDto taskReqDto) {

        Task task = taskService.findById(id);
        Task changedTask = TaskMapper.toEntity(taskReqDto);
        task.copy(changedTask);
        taskService.save(task);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Operation(
            summary = "Добавление комментария к задаче по id задачи",
            description = "Позволяет оставить комментарий под задачей"
    )

    @PatchMapping("/{id}/comments")
    public ResponseEntity<HttpStatus> addComment(@PathVariable("id") long id,
                                                 @Valid @RequestBody CommentReqDto commentReqDto) {

        Task task = taskService.findById(id);
        Comment comment = CommentMapper.toEntity(commentReqDto);
        comment.setTask(task);
        commentService.save(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);


    }

    @Operation(
            summary = "Удаление комментария",
            description = "Позволяет удалить комментарий под задачей"
    )

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") long id) {
        commentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
