package com.project.auditsystem.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um usuário do sistema de auditoria e versionamento de dados.
 */
@Entity
@Table(name = "users")
public class User {
//BANCO DE DADOS
// id identificar único gerado pelo banco
// created_at precisão temporal com UTC, default current_timestamp é que se nenhum valor ofr preenchido nessa coluna, o banco preenche com a data e hora atual.
    /**
     * Identificador único de usuário.
     * Sequência gerada automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Representa o nome do usuário no sistema
     */
    @Column(nullable = false, length = 150)
    private String name;

    /**
     * Representa o email do usuário no sistema
     */
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    /**
     * Representa a data/hora em UTC em que o usuário foi registrado no sistema.
     */
    @Column(name = "created_at", nullable = false, updatable = false, insertable = false )
    private Instant createdAt;

    /**
     * Transações associadas ao usuário.
     *Lado fraco do relacionamento entre User e Transaction (1-N).
     */
    //Relacionamento com transaction, uma lista para facilitar para o java a dependência
    //MappedBy sempre indica o lado que possui a fk
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions = new ArrayList<>();

    /**
     * Representa a senha do usuário em hash(criptografia)
     */
    @Column(name = "password_hash", length = 255, nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean active = true;


    public User() {
    }

    public User(Long id, String name, String email, Instant createdAt, List<Transaction> transactions, String password, Boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.transactions = transactions;
        this.password = password;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

