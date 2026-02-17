package com.project.auditsystem.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.Instant;

@Entity
@Table(name = "auditlogs")
public class AuditLog {
//BANCO DE DADOS
//id identificador único gerado pelo banco
//entity_name nome da entidade que sofreu uma ação
//Text armazena textos longos registra o estado dos dados sem limite prático, pois pode alterar um campo ou cinco campos
//created_at precisão do tempo em UTC
//user_id indica quem fez a ação
//fk primeiro declara a coluna, o tipo e not null, aplica a regra e nomeia a colunafk, indica a coluna da outra tabela do relacionamento, e faz referência para a outra tabela e sua pk.

    /**
     * Identificador único de auditlog.
     * Sequência gerada automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Representa a ação que foi feita sistema.
     */
    private String action;

    /**
     * Representa a entidade que sofreu a ação auditada.
     */
    @Column(name = "entity_name", nullable = false)
    private String entityName;

    /**
     * Representa o identificador único da entidade que sofreu a ação auditada.
     */
    @Column(name = "entity_id", nullable = false)
    private Long entityId;

    /**
     * Representa o estado antigo da ação.
     */
    @Column(name = "old_value")
    private String oldValue;

    /**
     * Representa o estado novo da ação.
     */
    @Column(name = "new_value")
    private String newValue;

    /**
     * Representa a data/hora em UTC em que a ação foi registrada no sistema.
     */
    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private Instant createdAt;

    /**
     * Usuário responsável pela ação auditada.
     */
    //Usuário responsável pela ação, lado forte com fk, "user_id" referencia a coluna da tbl user com pk
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public AuditLog() {
    }

    public AuditLog(Long id, String action, String entityName, Long entityId, String oldValue, String newValue, Instant createdAt, User user) {
        this.id = id;
        this.action = action;
        this.entityName = entityName;
        this.entityId = entityId;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
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
