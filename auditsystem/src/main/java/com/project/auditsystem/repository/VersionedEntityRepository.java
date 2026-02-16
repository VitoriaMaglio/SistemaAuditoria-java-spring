package com.project.auditsystem.repository;

import com.project.auditsystem.entity.VersionedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VersionedEntityRepository extends JpaRepository<VersionedEntity, Long> {
//Histórico de versões de uma entidade
    List<VersionedEntity> findByEntityNameAndEntityIdOrderByVersionDesc(String entityName, Long entityId);
}
