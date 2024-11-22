package org.example.taskservice.domain.mappers;

import org.example.taskservice.domain.dto.CommentReqDto;
import org.example.taskservice.domain.dto.CommentResDto;
import org.example.taskservice.domain.models.Comment;

public class CommentMapper {


    public static Comment toEntity(CommentReqDto dto) {
        Comment comment = new Comment();
        comment.setAuthor(dto.getAuthor());
        comment.setText(dto.getText());
        return comment;
    }

    public static CommentResDto toDto(Comment entity) {
        CommentResDto comment = new CommentResDto();
        comment.setAuthor(entity.getAuthor());
        comment.setCreationDate(entity.getCreationDate());
        comment.setText(entity.getText());
        comment.setId(entity.getId());
        return comment;
    }

}
