package org.example.taskservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.taskservice.domain.enums.TaskPriority;
import org.example.taskservice.domain.enums.TaskStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Входящая задача")
public class TaskReqDto {
    @Schema(description = "Заголовок задачи")
    @NotBlank
    private String header;
    @Schema(description = "Описание задачи")
    @NotBlank
    private String description;
    @Schema(description = "Статус задачи", example = "PENDING/PROGRESS/COMPLETED")
    @NotNull
    private TaskStatus taskStatus;
    @Schema(description = "Приоритет выполнения задачи", example = "LOW/MIDDLE/HIGH")
    @NotNull
    private TaskPriority taskPriority;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private PersonDto author;
    @Schema(description = "Email исполнителя задачи")
    @NotNull
    private PersonDto performer;

    @Override
    public String toString() {
        return "TaskReqDto{" +
                "header='" + header + '\'' +
                ", description='" + description + '\'' +
                ", taskStatus=" + taskStatus +
                ", taskPriority=" + taskPriority +
                ", author=" + author +
                ", performer=" + performer +
                '}';
    }
}
