package com.project.auditsystem.service;

import com.project.auditsystem.dto.request.UserRequestDTO;
import com.project.auditsystem.dto.response.UserResponseDTO;
import com.project.auditsystem.entity.User;

public class UserMapper {

    //Método que converte request para entidade
    public User toUserEntity(UserRequestDTO dtoUser){
        User user = new User();
        user.setName(dtoUser.getName());
        user.setEmail(dtoUser.getEmail());
        user.setPassword(dtoUser.getPassword());
        return user;
    }


    //Método que converte entidade para response
    public UserResponseDTO toUserResponseDto(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setCreated_at(user.getCreatedAt());
        return userResponseDTO;
    }

    //RequestDTO -> Entidade
    //o que entrar precisa ser dto para passar entre as camadas da aplicação




    //Entity -> ResponseDTO
    //precisa sair como um dto

}
