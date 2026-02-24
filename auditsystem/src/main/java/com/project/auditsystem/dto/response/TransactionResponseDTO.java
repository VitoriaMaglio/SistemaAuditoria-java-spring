package com.project.auditsystem.dto.response;


import java.math.BigDecimal;
import java.time.Instant;

public record TransactionResponseDTO (

     Long id,
     String description,
     BigDecimal amount,
     Instant created_at,
     String userName)


    {}
