package com.project.auditsystem.service;

import com.project.auditsystem.entity.VersionedEntity;
import com.project.auditsystem.repository.VersionedEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VersionedEntityService {
    @Autowired
    private VersionedEntityRepository versionedEntityRepository;

    public VersionedEntityService(VersionedEntityRepository versionedEntityRepository) {
        this.versionedEntityRepository = versionedEntityRepository;
    }
    public void createVersion(String entityName, Long entityId, String dataSnapshot) {
        VersionedEntity version = new VersionedEntity();
        version.setEntityName(entityName);
        version.setEntityId(entityId);
        version.setDataSnapshot(dataSnapshot);
        versionedEntityRepository.save(version);
    }

    public List<VersionedEntity> getVersions(String entityName, Long entityId) {
        return versionedEntityRepository.findByEntityNameAndEntityIdOrderByVersionDesc(entityName, entityId);
    }

}
