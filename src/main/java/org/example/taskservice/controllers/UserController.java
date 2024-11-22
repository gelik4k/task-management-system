package org.example.taskservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.taskservice.domain.dto.UserDto;
import org.example.taskservice.domain.mappers.PersonMapper;
import org.example.taskservice.domain.models.Person;
import org.example.taskservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "UserController", description = "Контроллер предоставляющий эндпоинты для регистрации и аутентификации пользователей")
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @Operation(
            summary = "Регистрация нового пользователя ",
            description = "Позволяет добавить нового пользователя в систему"
    )
    @PostMapping()
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserDto userDto) {
        Person person = PersonMapper.toEntity(userDto);
        userService.createUser(person);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Operation(
            summary = "Авторизация пользователя",
            description = "Позволяет сделать авторизацию пользователя"
    )
    @GetMapping("/signIn")
    public ResponseEntity<HttpStatus> signIn(@RequestParam String login, @RequestParam String password) {
        userService.signIn(login, password);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
