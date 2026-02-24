package com.project.auditsystem.service.mapper;

import com.project.auditsystem.dto.response.AlertResponseDTO;
import com.project.auditsystem.entity.Alert;

import java.util.List;


public class AlertMapper {
    public static AlertResponseDTO toAlertResponseDto(Alert alert){
        return new AlertResponseDTO(
                alert.getId(),
                alert.getDescription(),
                alert.getCreatedAt(),
                alert.getEntityName(),
                alert.getEntityId()

        );
    }

    public static List<AlertResponseDTO> toResponseDTOList(List<Alert> alerts) {
        return alerts.stream()
                .map(AlertMapper::toAlertResponseDto)
                .toList();
    }
}
