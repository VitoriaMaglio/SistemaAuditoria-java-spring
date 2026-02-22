package com.project.auditsystem.service;
import com.project.auditsystem.entity.User;
import com.project.auditsystem.entity.VersionedEntity;
import com.project.auditsystem.repository.UserRepository;
import com.project.auditsystem.repository.VersionedEntityRepository;
import com.project.auditsystem.service.mapper.UserSnapshotBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

/**
 * Service que contém a lógica de negócio para criação de estados de uma entidade
 */
@Service
public class VersionedEntityService {
    @Autowired
    private  VersionedEntityRepository versionedEntityRepository;
    @Autowired
    private  UserSnapshotBuilder userSnapshotBuilder;
    @Autowired
    private  UserRepository userRepository;
    public VersionedEntityService(){
    }

    public void createVersion(
            User user) {
        if (user == null || user.getId() == null) {
            throw new IllegalArgumentException("User não pode ser nulo e deve ter ID");
        }


        User managedUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User não encontrado"));

        VersionedEntity ve = new VersionedEntity();
        ve.setEntityName("User");
        ve.setEntityId(managedUser.getId());
        ve.setVersion(1);
        ve.setDataSnapshot(userSnapshotBuilder.build(managedUser));
        ve.setUser(managedUser);

        versionedEntityRepository.save(ve);
    }
    public List<VersionedEntity> getVersions(String entityName, Long entityId) {
        return versionedEntityRepository.findByEntityNameAndEntityIdOrderByVersionDesc(entityName, entityId);
    }

}
