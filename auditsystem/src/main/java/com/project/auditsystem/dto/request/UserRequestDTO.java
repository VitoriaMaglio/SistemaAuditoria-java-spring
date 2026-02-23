package com.project.auditsystem.dto.request;

import com.project.auditsystem.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserRequestDTO {

    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    private String password;

}
