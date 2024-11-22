package org.example.taskservice.services;

import org.example.taskservice.domain.models.Person;

public interface PersonService {
    Person findByEmail(String email);
}
