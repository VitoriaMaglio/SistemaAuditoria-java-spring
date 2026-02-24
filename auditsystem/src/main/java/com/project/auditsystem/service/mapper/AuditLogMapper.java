package com.project.auditsystem.service.mapper;

import com.project.auditsystem.dto.response.AuditLogResponseDTO;
import com.project.auditsystem.entity.AuditLog;

public class AuditLogMapper {
    //Método que converte entidade em response
    public AuditLogResponseDTO toAuditLogResponseDto(AuditLog auditLog){
        return new AuditLogResponseDTO(
                auditLog.getId(),
                auditLog.getAction(),
                auditLog.getEntityName(),
                auditLog.getEntityId(),
                auditLog.getOldValue(),
                auditLog.getNewValue(),
                auditLog.getCreatedAt()
        );
    }
}
