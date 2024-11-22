package org.example.taskservice.repositories;

import org.example.taskservice.domain.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);

    Optional<Person> findByUsername(String userName);
}
