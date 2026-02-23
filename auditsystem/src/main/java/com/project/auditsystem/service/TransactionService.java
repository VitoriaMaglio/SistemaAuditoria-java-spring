package com.project.auditsystem.service;
import com.project.auditsystem.dto.request.TransactionRequestDTO;
import com.project.auditsystem.dto.response.TransactionResponseDTO;
import com.project.auditsystem.entity.Transaction;
import com.project.auditsystem.entity.User;
import com.project.auditsystem.exception.TransactionNotFoundException;
import com.project.auditsystem.exception.UserInactiveException;
import com.project.auditsystem.exception.UserNotFoundException;
import com.project.auditsystem.repository.TransactionRepository;
import com.project.auditsystem.repository.UserRepository;
import com.project.auditsystem.service.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service Service que contém a lógica de negócio para criação transações no sistema
 */
@Service
public class TransactionService {

    @Autowired
    private  TransactionRepository transactionRepository;
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  AuditLogService auditLogService;
    @Autowired
    private AlertService alertService;

    public TransactionService(){}
    public TransactionResponseDTO createTransaction(TransactionRequestDTO transactionRequestDTO, String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);

        if (!user.getActive()) {
            throw new UserInactiveException();
        }
        Transaction transaction = TransactionMapper.toTransactionEntity(transactionRequestDTO);
        transaction.setUser(user);//IMPORTANTE -> atribuindo a transação ao user por conta do relacionamento

        Transaction transactionSaved = transactionRepository.save(transaction);
        alertService.createAlert(user, transactionSaved);
        alertService.createAlertDes(user, transactionSaved);
        auditLogService.logAction("CREATED", "Transaction", transaction.getId(), null, "Transação criada", user);

        return TransactionMapper.toTransactionResponseDto(transactionSaved);
        }

    public TransactionResponseDTO getTransactionById (Long id){
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(TransactionNotFoundException::new);
        return TransactionMapper.toTransactionResponseDto(transaction);
    }

}
