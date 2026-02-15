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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
