package org.example.taskservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.taskservice.domain.enums.Role;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Регистрация пользователя")
public class UserDto {

    @Schema(description = "Имя пользоватенля")
    @NotBlank
    private String username;

    @Schema(description = " Email пользователя")
    @NotBlank
    private String email;

    @Schema(description = "Пароль пользователя")
    @NotBlank
    private String password;

    @Schema(description = "Роль пользователя ADMIN/USER")
    @NotBlank
    private Role role;




}
