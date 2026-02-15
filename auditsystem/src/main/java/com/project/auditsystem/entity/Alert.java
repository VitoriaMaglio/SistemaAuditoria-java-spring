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
    private BigInteger entityId;

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



}
