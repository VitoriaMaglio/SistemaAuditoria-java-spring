package com.project.auditsystem.service;

import com.project.auditsystem.dto.response.AuditLogResponseDTO;
import com.project.auditsystem.dto.response.VersionedEntityResponseDTO;
import com.project.auditsystem.entity.AuditLog;
import com.project.auditsystem.entity.VersionedEntity;

public class VersionedEntityMapper {

    //Método que converte entidade para response
    public VersionedEntityResponseDTO toVersionedEntResponseDto(VersionedEntity versionedEntity){
        VersionedEntityResponseDTO versionedEntityResponseDTO = new VersionedEntityResponseDTO();
        versionedEntityResponseDTO.setId(versionedEntity.getId());
        versionedEntityResponseDTO.setEntityName(versionedEntity.getEntityName());
        versionedEntityResponseDTO.setEntityId(versionedEntity.getEntityId());
        versionedEntityResponseDTO.setVersion(versionedEntity.getVersion());
        versionedEntityResponseDTO.setDataSnapshot(versionedEntity.getDataSnapshot());
        versionedEntityResponseDTO.setCreatedAt(versionedEntity.getCreatedAt());
        versionedEntityResponseDTO.setUserName(versionedEntity.getUser().getName());
        return versionedEntityResponseDTO;
    }
}
