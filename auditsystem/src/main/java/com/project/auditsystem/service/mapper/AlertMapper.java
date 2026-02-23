package com.project.auditsystem.service.mapper;

import com.project.auditsystem.dto.response.AlertResponseDTO;
import com.project.auditsystem.entity.Alert;


public class AlertMapper {
    public AlertResponseDTO toAlertResponseDto(Alert alert){
        AlertResponseDTO alertResponseDTO = new AlertResponseDTO();
        alertResponseDTO.setId(alert.getId());
        alertResponseDTO.setDescription(alert.getDescription());
        alertResponseDTO.setCreated_at(alert.getCreatedAt());
        alertResponseDTO.setEntityName(alert.getEntityName());
        alertResponseDTO.setEntityId(alert.getEntityId());

        alertResponseDTO.setUserName(alert.getUser().getName());
        return alertResponseDTO;
    }
}
