package org.example.taskservice.services;

import org.example.taskservice.domain.models.Comment;

public interface CommentService {
    void save(Comment comment);

    void delete(long id);

    String findAuthorEmailById(long id);
}
