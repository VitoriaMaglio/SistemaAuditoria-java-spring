package com.project.auditsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class TransactionRequestDTO {
    //Aqui não pedir o user_id pois ele vem da autenticação, não do payload.
    //Ele é associado do Spring Security
    @NotBlank
    private String description;

    @NotNull
    @Positive
    private BigDecimal amount;


}
