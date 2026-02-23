package com.project.auditsystem.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@Entity
@Table(name = "auditlogs")
@NoArgsConstructor
@Getter
@Setter
public class AuditLog {
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
}
