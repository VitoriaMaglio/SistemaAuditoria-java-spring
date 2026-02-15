package com.project.auditsystem.service;

import com.project.auditsystem.dto.request.UserRequestDTO;
import com.project.auditsystem.dto.response.UserResponseDTO;
import com.project.auditsystem.entity.User;
import com.project.auditsystem.repository.UserRepository;
import com.project.auditsystem.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe que contém lógica de negócio de um usuário do sistema.
 */
@Service
public class UserService {

    /**
     * Injeção de dependência para a camada repository de acesso ao banco.
     */
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Método para cadastro de um usuário no sistema
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
        //lógica cadastro-> só cadastrar user se email nunca tiver sido registrado

        if (userRepository.existsByEmail(userRequestDTO.getEmail())){
            throw new RuntimeException("Email já cadastrado");
        }
            //Para salvar no banco-> converte dto para entidade bruta e salva

            User user = UserMapper.toUserEntity(userRequestDTO);
            User savedUser = userRepository.save(user);

            //auditoria de user

        //Retorna uma responsedto (seguro)
        return UserMapper.toUserResponseDto(savedUser);

    }

}
