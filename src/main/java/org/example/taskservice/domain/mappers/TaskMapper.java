package org.example.taskservice.domain.mappers;

import org.example.taskservice.domain.dto.CommentResDto;
import org.example.taskservice.domain.dto.PersonDto;
import org.example.taskservice.domain.dto.TaskReqDto;
import org.example.taskservice.domain.dto.TaskResDto;
import org.example.taskservice.domain.models.Person;
import org.example.taskservice.domain.models.Task;

import java.util.List;
import java.util.stream.Collectors;

public class TaskMapper {

    public static Task toEntity(TaskReqDto dto) {
        Task task = new Task();
        task.setHeader(dto.getHeader());
        task.setDescription(dto.getDescription());
        task.setTaskStatus(dto.getTaskStatus());
        task.setTaskPriority(dto.getTaskPriority());
        Person authorEntity = PersonMapper.toEntity(dto.getAuthor());
        task.setAuthor(authorEntity);
        Person performer = PersonMapper.toEntity(dto.getPerformer());
        task.setPerformer(performer);
        return task;
    }

    public static TaskResDto toDto(Task entity) {
        TaskResDto taskResDto = new TaskResDto();
        taskResDto.setHeader(entity.getHeader());
        taskResDto.setDescription(entity.getDescription());
        taskResDto.setTaskStatus(entity.getTaskStatus());
        taskResDto.setTaskPriority(entity.getTaskPriority());

        PersonDto authorDto = PersonMapper.toDto(entity.getAuthor());
        taskResDto.setAuthor(authorDto);
        PersonDto performerDto = PersonMapper.toDto(entity.getPerformer());
        taskResDto.setPerformer(performerDto);
        List<CommentResDto> commentResDtos = entity.getComments()
                .stream()
                .map(CommentMapper::toDto)
                .collect(Collectors.toList());
        taskResDto.setComments(commentResDtos);
        taskResDto.setCreationDate(entity.getCreationDate());
        return taskResDto;

    }

}
