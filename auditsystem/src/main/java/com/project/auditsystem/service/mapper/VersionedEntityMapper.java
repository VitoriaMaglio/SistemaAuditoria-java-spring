package com.project.auditsystem.service.mapper;

import com.project.auditsystem.dto.response.VersionedEntityResponseDTO;
import com.project.auditsystem.entity.VersionedEntity;

public class VersionedEntityMapper {

    //Método que converte entidade para response
    public VersionedEntityResponseDTO toVersionedEntResponseDto(VersionedEntity versionedEntity){
        return new VersionedEntityResponseDTO(
                versionedEntity.getId(),
                versionedEntity.getEntityName(),
                versionedEntity.getEntityId(),
                versionedEntity.getVersion(),
                versionedEntity.getDataSnapshot(),
                versionedEntity.getCreatedAt()
        );
    }
}
