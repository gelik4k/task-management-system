package org.example.taskservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Входящий комментарий")
public class CommentReqDto {
    @Schema(description = "Текст комментария")
    @NotBlank
    private String text;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @NotBlank
    private String author;

}
