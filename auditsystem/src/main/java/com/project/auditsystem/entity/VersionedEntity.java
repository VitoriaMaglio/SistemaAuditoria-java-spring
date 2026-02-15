package com.project.auditsystem.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.Instant;

/**
 * Classe que guarda versões dos dados do sistema.
 */
@Entity
@Table(name = "versionedentities")
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
    private Integer version;
    /**
     * Representa o estao completo da entidade no sistema.
     */
    @Column(name = "data_snapshot", columnDefinition = "jsonb", nullable = false)
    private String dataSnapshot;

    /**
     * Representa a data/hora em UTC em que a entidade foi versionada.
     */

    @Column(name = "created_at" , nullable = false, updatable = false)
    private Instant createdAt;

    //Usuário responsável pela ação, lado forte com fk, "user_id" referencia a coluna da tbl user com pk
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public VersionedEntity() {
    }

    public VersionedEntity(Long id, String entityName, Long entityId, Integer version, String dataSnapshot, Instant createdAt, User user) {
        this.id = id;
        this.entityName = entityName;
        this.entityId = entityId;
        this.version = version;
        this.dataSnapshot = dataSnapshot;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDataSnapshot() {
        return dataSnapshot;
    }

    public void setDataSnapshot(String dataSnapshot) {
        this.dataSnapshot = dataSnapshot;
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
