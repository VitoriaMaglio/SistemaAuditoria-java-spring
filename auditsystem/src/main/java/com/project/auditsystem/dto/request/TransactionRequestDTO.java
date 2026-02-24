package com.project.auditsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;


public record TransactionRequestDTO (
    @NotBlank
    String description,

    @NotNull
    @Positive
    BigDecimal amount,

    @NotBlank
    String email) {}
