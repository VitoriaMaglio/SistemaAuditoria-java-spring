package com.project.auditsystem.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * Classe que representa uma transação financeira registrada no sistema e utilizada como base para auditoria.
 */
@Entity
@Table(name = "transactions")
public class Transaction {
//BANCO DE DADOS
// created_at precisão temporal com UTC, default current_timestamp é que se nenhum valor for preenchido nessa coluna, o banco preenche com a data e hora atual.
//user_id relacionamento fk : declara a regra e nomeia a colunafk, declara a coluna com a fk, referencia a coluna e sua pk e define que nenhum usuário pode ser apagado se tiver transações associadas.
    /**
     * Identificador único de transação.
     * Sequência gerada automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Representa a descrição da transação.
     */
    @Column(nullable = false, length = 250)
    private String description;

    /**
     * Representa o valor da transação.
     */
    @Column(nullable = false,precision = 10, scale = 2)
    private BigDecimal amount;

    /**
     * Representa a data/hora em UTC em que a transação foi registrada no sistema.
     */
    //Quando o atributo não tiver o mesmo nome da coluna na tabela, mapear com o nome da tabela
    @Column(name = "created_at" , nullable = false, updatable = false, insertable = false)
    private Instant createdAt;

    /**
     *Transações dependentes de um usuário.
     *Lado forte do relacionamento entre User e Transaction (1-N).
     */
    //Lado da relação com fk, esse "user" é o que está mapeado na entidade User indicando o outro lado da relação
    //esse "user_id" indica a coluna na tabela que tem a fk
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Transaction() {
    }

    public Transaction(Long id, String description, BigDecimal amount, Instant createdAt, User user) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.createdAt = createdAt;
        this.user = user;
    }

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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
