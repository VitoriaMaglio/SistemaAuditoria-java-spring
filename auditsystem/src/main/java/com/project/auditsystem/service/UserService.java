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

    private AuditLogService auditLogService;
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}
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
            auditLogService.logAction("CREATE", "User", user.getId(), null, "Usuário criado",user);
        //Retorna uma responsedto (seguro)
        return UserMapper.toUserResponseDto(savedUser);
    }
    //Método para get user por id
    public UserResponseDTO getUserById(Long id){
        User user = userRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        return UserMapper.toUserResponseDto(user);
    }
    //Método para atualizar dados de um user
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        if (!user.getActive()){
            throw new RuntimeException("Usuário inativo não pode ser alterado");
        }
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        User updatedUser = userRepository.save(user);
        return UserMapper.toUserResponseDto(updatedUser);
    }
    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        if (!user.getActive()){
            throw new RuntimeException("Usuário já está inativo.");
        }
        user.setActive(false);
        userRepository.save(user);
    }
}
