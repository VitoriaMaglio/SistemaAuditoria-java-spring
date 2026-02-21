package com.project.auditsystem.service;
import com.project.auditsystem.entity.User;
import com.project.auditsystem.entity.VersionedEntity;
import com.project.auditsystem.repository.VersionedEntityRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

/**
 * Service que contém a lógica de negócio para criação de estados de uma entidade
 */
@Service
public class VersionedEntityService {
    private final VersionedEntityRepository versionedEntityRepository;

    public VersionedEntityService(VersionedEntityRepository versionedEntityRepository) {
        this.versionedEntityRepository = versionedEntityRepository;}

    public void createVersion(
            String entityName,
            Long entityId,
            Integer version,
            String dataSnapshot,
            User user) {
        VersionedEntity ve = new VersionedEntity();
        ve.setEntityName(entityName);
        ve.setEntityId(entityId);
        ve.setVersion(version);
        ve.setDataSnapshot(dataSnapshot);
        ve.setUser(user);

        versionedEntityRepository.save(ve);
    }
    public List<VersionedEntity> getVersions(String entityName, Long entityId) {
        return versionedEntityRepository.findByEntityNameAndEntityIdOrderByVersionDesc(entityName, entityId);
    }

}
