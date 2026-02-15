package com.project.auditsystem.entity;

import jakarta.persistence.*;
import org.yaml.snakeyaml.events.Event;

import java.math.BigInteger;
import java.time.Instant;

/**
 * Classe que representa um alerta para quando houver ações suspeitas no sistema.
 */
@Entity
@Table(name = "alerts")
public class Alert {
    /**
     * Identificador único de alerta.
     * Sequência gerada automaticamente pelo banco de dados.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

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
     * Representa a data/hora em UTC em que o alerta foi registrado no sistema.
     */
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    /**
     * Usuário responsável pela geração do alerta no sistema.
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Alert() {
    }

    public Alert(Long id, String description, String entityName, Long entityId, Instant createdAt, User user) {
        this.id = id;
        this.description = description;
        this.entityName = entityName;
        this.entityId = entityId;
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
