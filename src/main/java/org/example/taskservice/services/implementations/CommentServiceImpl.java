package org.example.taskservice.services.implementations;


import org.example.taskservice.domain.models.Comment;
import org.example.taskservice.repositories.CommentRepo;
import org.example.taskservice.services.CommentService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;

    public CommentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    public void save(Comment comment) {
        comment.setCreationDate(LocalDateTime.now());
        commentRepo.save(comment);
    }

    public void delete(long id) {
        commentRepo.deleteById(id);
    }

    public String findAuthorEmailById(long id) {
        return commentRepo.findAuthorEmailById(id)
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
