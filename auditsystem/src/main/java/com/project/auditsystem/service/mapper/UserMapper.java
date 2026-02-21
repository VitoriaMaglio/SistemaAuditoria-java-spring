package com.project.auditsystem.service.mapper;

import com.project.auditsystem.dto.request.UserRequestDTO;
import com.project.auditsystem.dto.response.UserResponseDTO;
import com.project.auditsystem.entity.User;

import java.io.Serializable;
import java.util.Map;

public class UserMapper {

    //Método que converte request para entidade

    //método static pois Mapper não tem estado; assim não precisa instanciar a classe para chamar no service
    //Mapper não precisa ser injetado pois não é um Bean do Spring; static evita instância desnecessária

    public static User toUserEntity(UserRequestDTO dtoUser){
        User user = new User();
        user.setName(dtoUser.getName());
        user.setEmail(dtoUser.getEmail());
        user.setPassword(dtoUser.getPassword());
        return user;
    }


    //Método que converte entidade para response
    public static UserResponseDTO toUserResponseDto(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setCreated_at(user.getCreatedAt());
        userResponseDTO.setActive(user.getActive());
        return userResponseDTO;
    }



    //RequestDTO -> Entidade
    //o que entrar precisa ser dto para passar entre as camadas da aplicação




    //Entity -> ResponseDTO
    //precisa sair como um dto

}
