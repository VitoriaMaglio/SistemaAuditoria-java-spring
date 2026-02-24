package com.project.auditsystem.service;
import com.project.auditsystem.dto.request.UserRequestDTO;
import com.project.auditsystem.dto.response.UserResponseDTO;
import com.project.auditsystem.entity.User;
import com.project.auditsystem.exception.RegisteredEmailException;
import com.project.auditsystem.exception.UserInactiveException;
import com.project.auditsystem.exception.UserNotFoundException;
import com.project.auditsystem.repository.UserRepository;
import com.project.auditsystem.repository.VersionedEntityRepository;
import com.project.auditsystem.service.mapper.UserMapper;
import com.project.auditsystem.service.mapper.UserSnapshotBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service que contém lógica de negócio de um usuário do sistema.
 */
@Service
public class UserService {
    /**
     * Injeção de dependência para a camada repository de acesso ao banco.
     */

    private final UserRepository userRepository;

    private final AuditLogService auditLogService;

    private final AlertService alertService;

    private final VersionedEntityService versionedEntityService;

    private final UserSnapshotBuilder userSnapshotBuilder;

    private final VersionedEntityRepository versionedEntityRepository;

    public UserService(UserRepository userRepository, AuditLogService auditLogService, AlertService alertService, VersionedEntityService versionedEntityService, UserSnapshotBuilder userSnapshotBuilder, VersionedEntityRepository versionedEntityRepository){
        this.userRepository = userRepository;
        this.auditLogService = auditLogService;
        this.alertService = alertService;
        this.versionedEntityService = versionedEntityService;
        this.userSnapshotBuilder = userSnapshotBuilder;
        this.versionedEntityRepository = versionedEntityRepository;
    }

    //Método para cadastro de um usuário no sistema
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
        //lógica cadastro-> só cadastrar user se email nunca tiver sido registrado
        if (userRepository.existsByEmail(userRequestDTO.getEmail())){
            throw new RegisteredEmailException();
        }
            User user = UserMapper.toUserEntity(userRequestDTO);
            User savedUser = userRepository.save(user);
            //auditoria de user
            auditLogService.logAction("CREATE", "User", user.getId(), null, "Usuário criado",user);
            alertService.createAlertUser(savedUser);
        return UserMapper.toUserResponseDto(savedUser);
    }
    //Método para get user por id
    public UserResponseDTO getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return UserMapper.toUserResponseDto(user);
    }
    public UserResponseDTO inactivateUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        user.setActive(false);
        userRepository.save(user);
        return UserMapper.toUserResponseDto(user);
    }

    //Método para atualizar dados de um user
    @Transactional
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto){
        User user = userRepository.findByIdAndActiveTrue(id)
                .orElseThrow(UserNotFoundException::new);
        if (!user.getActive()){
            throw new UserInactiveException();
        }
        String snapshot = userSnapshotBuilder.build(user);

        Integer nextVersion = versionedEntityRepository
                .findTopByEntityNameAndEntityIdOrderByVersionDesc("User", user.getId())
                .map(v -> v.getVersion() + 1)
                .orElse(1);
        versionedEntityService.createVersion(user);
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        User updatedUser = userRepository.save(user);
        auditLogService.logAction(
                "UPDATED",
                "User",
                updatedUser.getId(),
                snapshot,
                userSnapshotBuilder.build(updatedUser),
                user
        );
        return UserMapper.toUserResponseDto(updatedUser);
    }
    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        if (!user.getActive()){
            throw new UserInactiveException();
        }
        user.setActive(false);
        userRepository.save(user);
    }
}
