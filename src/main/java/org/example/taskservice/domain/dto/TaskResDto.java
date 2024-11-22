package org.example.taskservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.taskservice.domain.enums.TaskPriority;
import org.example.taskservice.domain.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Входящая задача")
public class TaskResDto {
    @Schema(description = "Заголовок задачи")
    private String header;
    @Schema(description = "Описание задачи")
    private String description;
    @Schema(description = "Статус задачи", example = "PENDING/PROGRESS/COMPLETED")
    private TaskStatus taskStatus;
    @Schema(description = "Приоритет выполнения задачи", example = "LOW/MIDDLE/HIGH")
    private TaskPriority taskPriority;
    @Schema(description = "Email автора задачи")
    private PersonDto author;
    @Schema(description = "Email исполнителя задачи")
    private PersonDto performer;
    @Schema(description = "Комментарии под задачей")
    private List<CommentResDto> comments;
    @Schema(description = "Дата создания задачи")
    private LocalDateTime creationDate;

}
