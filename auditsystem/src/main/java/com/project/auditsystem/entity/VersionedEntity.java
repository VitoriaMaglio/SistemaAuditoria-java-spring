package com.project.auditsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;

/**
 * Classe que guarda versões dos dados do sistema.
 */
@Entity
@Table(name = "versionedentities")
@NoArgsConstructor
@Getter
@Setter
public class VersionedEntity {
//BANCO DE DADOS
//JSONB armazena json de forma binária e estruturada, permite consultas dentro do json
    /**
     * Identificador único de transação.
     * Sequence gerade automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * Representa a versão em que o dado está registrado no sistema.
     */
    @Column(nullable = false)
    @Version
    private Integer version;
    /**
     * Representa o estado completo da entidade no sistema.
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "data_snapshot", columnDefinition = "jsonb", nullable = false)
    private String dataSnapshot;

    /**
     * Representa a data/hora em UTC em que a entidade foi versionada.
     */

    @Column(name = "created_at" , nullable = false, updatable = false,insertable = false)
    private Instant createdAt;

    //Usuário responsável pela ação, lado forte com fk, "user_id" referencia a coluna da tbl user com pk
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
   private User user;


}
