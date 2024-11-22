package org.example.taskservice.services;

import org.example.taskservice.domain.models.Person;

public interface UserService {
    void createUser(Person person);
    
    void signIn(String login, String password);
}
