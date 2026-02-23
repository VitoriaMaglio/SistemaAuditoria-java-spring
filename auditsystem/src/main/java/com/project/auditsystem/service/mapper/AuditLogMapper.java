package com.project.auditsystem.service.mapper;

import com.project.auditsystem.dto.response.AuditLogResponseDTO;
import com.project.auditsystem.entity.AuditLog;

public class AuditLogMapper {
    //Método que converte entidade em response
    public AuditLogResponseDTO toAuditLogResponseDto(AuditLog auditLog){
        AuditLogResponseDTO auditLogResponseDTO = new AuditLogResponseDTO();
        auditLogResponseDTO.setId(auditLog.getId());
        auditLogResponseDTO.setAction(auditLog.getAction());
        auditLogResponseDTO.setEntityName(auditLog.getEntityName());
        auditLogResponseDTO.setEntityId(auditLog.getEntityId());
        auditLogResponseDTO.setOldValue(auditLog.getOldValue());
        auditLogResponseDTO.setNewValue(auditLog.getNewValue());
        auditLogResponseDTO.setCreatedAt(auditLog.getCreatedAt());
        return auditLogResponseDTO;
    }
}
