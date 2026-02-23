package com.project.auditsystem.service.mapper;

import com.project.auditsystem.dto.request.UserRequestDTO;
import com.project.auditsystem.dto.response.UserResponseDTO;
import com.project.auditsystem.entity.User;

import java.io.Serializable;
import java.util.Map;

public class UserMapper {

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


}
