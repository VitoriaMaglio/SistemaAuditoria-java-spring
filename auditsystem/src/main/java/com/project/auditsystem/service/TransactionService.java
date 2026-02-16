package com.project.auditsystem.service;

import com.project.auditsystem.dto.request.TransactionRequestDTO;
import com.project.auditsystem.dto.response.TransactionResponseDTO;
import com.project.auditsystem.dto.response.UserResponseDTO;
import com.project.auditsystem.entity.Transaction;
import com.project.auditsystem.entity.User;
import com.project.auditsystem.repository.TransactionRepository;
import com.project.auditsystem.repository.UserRepository;
import com.project.auditsystem.service.mapper.TransactionMapper;
import com.project.auditsystem.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;

    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    //CreateTransaction validar se existe user por email e se user está ativo
    public TransactionResponseDTO createTransaction(TransactionRequestDTO transactionRequestDTO, String email){
        User user = userRepository.findByEmailAndActiveTrue(email)
                .orElseThrow(()-> new RuntimeException("Usuário não existe ou está inativo."));
        Transaction transaction = TransactionMapper.toTransactionEntity(transactionRequestDTO);
        transaction.setUser(user);//IMPORTANTE -> atribuindo a transação ao user por conta do relacionamento
        Transaction transactionSaved = transactionRepository.save(transaction);
        return TransactionMapper.toTransactionResponseDto(transactionSaved);
        }

    //Relacionamentos só são definidos em métodos de create ou update, nunca em get

    //Buscar uma transação -> verificar se existe um user ativo relacionado a esa ação
    //Valido, realizar a busca da transação por id
    public TransactionResponseDTO getTransactionById (Long id, String email){
        User user = userRepository.findByEmailAndActiveTrue(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        //adicionar lógica para se o usuário for inativo
        Transaction transaction = transactionRepository.findByIdAndUserEmail(id, email)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada."));

        return TransactionMapper.toTransactionResponseDto(transaction);
    }
}



