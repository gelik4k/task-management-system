package org.example.taskservice.services.implementations;

import org.example.taskservice.domain.models.Person;
import org.example.taskservice.repositories.PersonRepo;
import org.example.taskservice.services.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepo personRepo;

    public PersonServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person findByEmail(String email) {
        return personRepo.findByEmail(email).orElseThrow(() -> new IllegalArgumentException(email));
    }
}
