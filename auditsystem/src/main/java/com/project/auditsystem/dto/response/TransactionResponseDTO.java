package com.project.auditsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionResponseDTO {
    //Aqui tbm não retorna o user_id associado a transação, uma vez que estaria expondo identificadores internos

    private Long id;
    private String description;
    private BigDecimal amount;
    private Instant created_at;
    private String userName;


}
