package com.project.auditsystem.dto.request;

import com.project.auditsystem.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequestDTO {
    //DTO Data Transfer Object -> os dados brutos(banco) não são transferidos entre as camadas, e sim, os dados selecionados
    //Protege a integridade do banco e controla o q entra e sai da api, evita exposição de dados sensíveis

    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }







}
