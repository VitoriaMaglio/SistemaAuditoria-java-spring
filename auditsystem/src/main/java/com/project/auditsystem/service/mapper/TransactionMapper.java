package com.project.auditsystem.service.mapper;

import com.project.auditsystem.dto.request.TransactionRequestDTO;
import com.project.auditsystem.dto.response.TransactionResponseDTO;
import com.project.auditsystem.entity.Transaction;

public class TransactionMapper {

    //Método que converte request para entidade transaction
    public static Transaction toTransactionEntity(TransactionRequestDTO transactionRequestDTO){
        Transaction transaction = new Transaction();
        transaction.setDescription(transactionRequestDTO.description());
        transaction.setAmount(transactionRequestDTO.amount());
        return transaction;
    }

    //Método que converte entidade para response
    public static TransactionResponseDTO toTransactionResponseDto(Transaction transaction) {
        return new TransactionResponseDTO(
                transaction.getId(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getCreatedAt(),
                transaction.getUser().getName()
        );
    }
}

