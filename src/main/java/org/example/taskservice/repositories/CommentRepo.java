package org.example.taskservice.repositories;

import org.example.taskservice.domain.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    Optional<String> findAuthorEmailById(long id);
}
