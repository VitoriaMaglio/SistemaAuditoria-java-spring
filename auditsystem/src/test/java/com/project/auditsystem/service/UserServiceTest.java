package com.project.auditsystem.service;

import com.project.auditsystem.dto.request.UserRequestDTO;
import com.project.auditsystem.dto.response.UserResponseDTO;
import com.project.auditsystem.entity.User;
import com.project.auditsystem.exception.RegisteredEmailException;
import com.project.auditsystem.repository.UserRepository;
import com.project.auditsystem.repository.VersionedEntityRepository;
import com.project.auditsystem.service.mapper.UserSnapshotBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private  UserRepository userRepository;
    @Mock
    private  AuditLogService auditLogService;
    @Mock
    private  AlertService alertService;
    @Mock
    private VersionedEntityService versionedEntityService;
    @Mock
    private  UserSnapshotBuilder userSnapshotBuilder;
    @Mock
    private  VersionedEntityRepository versionedEntityRepository;

    @Autowired
    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("Should create user successfully" )
    void createUserCase1() {

        /// AAA
        //Arrange
        //DTO simula o que o controller enviaria
        UserRequestDTO requestDTO = new UserRequestDTO("User","teste@email.com","Senah123");
        //Entidade simula o retorno do banco
        User user = new User();
        user.setId(1L);
        user.setEmail("teste@email.com");

        //Simula que o emial ainda n existe
        when(userRepository.existsByEmail("teste@email.com"))
                .thenReturn(false);
        //Evita acesso ao banco real
        when(userRepository.save(any(User.class)))
                .thenReturn(user);

        //Act
        UserResponseDTO response = userService.createUser(requestDTO);

        //Assert
        //Garante que o método não retornou null
        assertNotNull(response);
        //Confirma que dado funcionou
        assertEquals("teste@email.com", response.getEmail());

        verify(userRepository).existsByEmail("teste@email.com");
        verify(userRepository).save(any(User.class));
        //Garante regra do sistema
        verify(auditLogService).logAction(
                eq("CREATE"),
                eq("User"),
                isNull(),
                isNull(),
                eq("Usuário criado"),
                any(User.class)
        );
        //Garante regra do sistema
        verify(alertService).createAlertUser(user);

    }

    @Test
    @DisplayName("Should throw exception RegisteredEmailException" )
    void createUserCase2() {

        /// AAA
        //Arrange
        //DTO simula o que o controller enviaria
        UserRequestDTO requestDTO = new UserRequestDTO("User","teste@email.com","Senah123");

        //Simula que o emial ainda n existe
        when(userRepository.existsByEmail("teste@email.com"))
                .thenReturn(true);

        //Act
        assertThrows(
                RegisteredEmailException.class,
                () -> userService.createUser(requestDTO));
        //Assert
        verify(userRepository).existsByEmail("teste@email.com");
        verify(userRepository, never()).save(any());
        verifyNoInteractions(auditLogService, alertService);
    }

}