package com.project.auditsystem.service;

import com.project.auditsystem.dto.request.TransactionRequestDTO;
import com.project.auditsystem.dto.response.TransactionResponseDTO;
import com.project.auditsystem.entity.Transaction;
import com.project.auditsystem.entity.User;
import com.project.auditsystem.exception.UserInactiveException;
import com.project.auditsystem.repository.TransactionRepository;
import com.project.auditsystem.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private  AuditLogService auditLogService;
    @Mock
    private AlertService alertService;

    @Autowired
    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should create transaction successfully")
    void createTransactionCase1() {
        //Arrange

        User user = new User();
        String email = "user@email.com";
        user.setId(1L);
        user.setActive(true);
        TransactionRequestDTO requestDTO = new TransactionRequestDTO("Descrição", new BigDecimal("2.00"), email);
        Transaction transactionSaved = new Transaction();
        transactionSaved.setId(10L);
        transactionSaved.setUser(user);

        when(userRepository.findByEmail(email))
                .thenReturn(Optional.of(user));

        when(transactionRepository.save(any(Transaction.class)))
                .thenReturn(transactionSaved);

        //act
        TransactionResponseDTO response =
                transactionService.createTransaction(requestDTO, email);

        //Assert
        assertNotNull(response);

        verify(userRepository).findByEmail(email);
        verify(transactionRepository).save(any(Transaction.class));

        verify(alertService).createAlert(user, transactionSaved);
        verify(alertService).createAlertDes(user, transactionSaved);

        verify(auditLogService).logAction(
                eq("CREATED"),
                eq("Transaction"),
                isNull(),
                isNull(),
                eq("Transação criada"),
                eq(user)
        );

    }

    @Test
    @DisplayName("Should throw exception UserInactiveException ")
    void createTransactionCase2() {
        // Arrange
        String email = "user@email.com";

        User user = new User();
        user.setActive(false);

        when(userRepository.findByEmail(email))
                .thenReturn(Optional.of(user));

        // Act + Assert
        assertThrows(
                UserInactiveException.class,
                () -> transactionService.createTransaction(new TransactionRequestDTO("Descrição",
                        new BigDecimal("2.00"),
                        email
                ),
                        email)
        );

        verify(userRepository).findByEmail(email);
        verify(transactionRepository, never()).save(any());
        verifyNoInteractions(alertService, auditLogService);
    }
}