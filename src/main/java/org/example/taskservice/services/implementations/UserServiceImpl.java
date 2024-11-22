package org.example.taskservice.services.implementations;

import org.example.taskservice.domain.models.Person;
import org.example.taskservice.repositories.PersonRepo;
import org.example.taskservice.services.UserService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
@Service
public class UserServiceImpl implements UserService {
    private final PersonRepo personRepo;

    public UserServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public void createUser(Person person) {
        personRepo.findByEmail(person.getEmail()).ifPresent(e -> {
            throw new IllegalArgumentException("Пользователь с таким Email существует");
        });

        personRepo.findByUsername(person.getUsername()).ifPresent(e -> {
            throw new IllegalArgumentException("Пользователь с таким Именем существует");
        });

        person.setCreationDate(LocalDateTime.now());
        personRepo.save(person);
    }

    //TODO подключить spring security, реализовать сервис авторизации и аутентификации, выдача JWT
    @Override
    public void signIn(String login, String password) {
        Person person = personRepo.findByUsername(login).orElseThrow(() -> new IllegalArgumentException("Пользователь не найден"));
        if (!person.getPassword().equals(password)) {
            throw new IllegalArgumentException("Пароль не верный");
        }
    }
}

