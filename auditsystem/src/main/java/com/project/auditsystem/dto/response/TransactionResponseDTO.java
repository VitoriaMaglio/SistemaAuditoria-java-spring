package com.project.auditsystem.dto.response;

import java.math.BigDecimal;
import java.time.Instant;

public class TransactionResponseDTO {
    //Aqui tbm não retorna o user_id associado a transação, uma vez que estaria expondo identificadores internos

    private Long id;
    private String description;
    private BigDecimal amount;
    private Instant created_at;
    private String userName;
}
