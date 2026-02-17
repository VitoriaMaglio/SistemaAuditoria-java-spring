package com.project.auditsystem.controller;

import com.project.auditsystem.dto.request.TransactionRequestDTO;
import com.project.auditsystem.dto.request.UserRequestDTO;
import com.project.auditsystem.dto.response.TransactionResponseDTO;
import com.project.auditsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsável por expor os endpoints REST
 * relacionados ao gerenciamento de transações do sistema.
 */
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //Método para cadastro de uma transação
    @PostMapping
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO){
        String emailUserLogado = "vitoria.maglio@email.com";//depois vem da autenticação jwt
        TransactionResponseDTO transactionResponseDTO = transactionService.createTransaction(transactionRequestDTO, emailUserLogado);
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.createTransaction(transactionRequestDTO, emailUserLogado));
    }

    //Método para busca de transação
    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> getTransactionById (@PathVariable Long id, @RequestParam String email){
        TransactionResponseDTO transactionResponseDTO = transactionService.getTransactionById(id, email);
        return ResponseEntity.ok(transactionResponseDTO);

    }

}
