package com.project.auditsystem.service.mapper;

import com.project.auditsystem.dto.request.TransactionRequestDTO;
import com.project.auditsystem.dto.response.TransactionResponseDTO;
import com.project.auditsystem.entity.Transaction;

public class TransactionMapper {

    //Método que converte request para entidade transaction
    public static Transaction toTransactionEntity(TransactionRequestDTO transactionRequestDTO){
        Transaction transaction = new Transaction();
        transaction.setDescription(transactionRequestDTO.getDescription());
        transaction.setAmount(transactionRequestDTO.getAmount());
        return transaction;
    }

    //Método que converte entidade para response
    public static TransactionResponseDTO toTransactionResponseDto(Transaction transaction) {
        TransactionResponseDTO transactionResponsetDTO = new TransactionResponseDTO();
        transactionResponsetDTO.setId(transaction.getId());
        transactionResponsetDTO.setDescription(transaction.getDescription());
        transactionResponsetDTO.setAmount(transaction.getAmount());
        transactionResponsetDTO.setCreated_at(transaction.getCreatedAt());
        transactionResponsetDTO.setUserName(transaction.getUser().getName());

        return transactionResponsetDTO;
    }
}
