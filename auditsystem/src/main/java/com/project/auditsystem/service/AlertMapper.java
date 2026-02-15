package com.project.auditsystem.service;

import com.project.auditsystem.dto.response.AlertResponseDTO;
import com.project.auditsystem.dto.response.AuditLogResponseDTO;
import com.project.auditsystem.entity.Alert;
import com.project.auditsystem.entity.AuditLog;

public class AlertMapper {


    //Método que converte entidade em response
    public AlertResponseDTO toAlertResponseDto(Alert alert){
        AlertResponseDTO alertResponseDTO = new AlertResponseDTO();
        alertResponseDTO.setId(alert.getId());
        alertResponseDTO.setDescription(alert.getDescription());
        alertResponseDTO.setEntityName(alert.getEntityName());
        alertResponseDTO.setEntityId(alert.getEntityId());
        alertResponseDTO.setCreatedAt(alert.getCreatedAt());
        alertResponseDTO.setUserName(alert.getUser().getName());
        return alertResponseDTO;
    }
}
