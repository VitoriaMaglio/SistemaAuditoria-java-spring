package com.project.auditsystem.service.mapper;

import com.project.auditsystem.dto.request.UserRequestDTO;
import com.project.auditsystem.dto.response.UserResponseDTO;
import com.project.auditsystem.entity.User;

import java.io.Serializable;
import java.util.Map;

public class UserMapper {

    public static User toUserEntity(UserRequestDTO dtoUser){
        User user = new User();
        user.setName(dtoUser.name());
        user.setEmail(dtoUser.email());
        user.setPassword(dtoUser.password());
        return user;
    }

    //Método que converte entidade para response
    public static UserResponseDTO toUserResponseDto(User user){
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getActive()
        );
    }


}
