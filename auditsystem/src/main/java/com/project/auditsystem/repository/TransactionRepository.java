package com.project.auditsystem.repository;

import com.project.auditsystem.dto.response.UserResponseDTO;
import com.project.auditsystem.entity.Transaction;
import com.project.auditsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

 //Criar e buscar transações depende da existência e status ativo do user
    Optional<Transaction> findByIdAndUserEmail(Long id, String email);
}
