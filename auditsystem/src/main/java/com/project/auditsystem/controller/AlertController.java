package com.project.auditsystem.controller;

import com.project.auditsystem.dto.response.AlertResponseDTO;
import com.project.auditsystem.entity.Alert;
import com.project.auditsystem.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe que representa requisição de alertas : busca alerta por usuário.
 */
@RestController
@RequestMapping("/alerts")
public class AlertController {
    @Autowired
    private AlertService alertService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<AlertResponseDTO>> getAlertsByUser(@PathVariable Long userId){
        List<Alert> alerts = alertService.findAlertsByUser(userId);
        List<AlertResponseDTO> dto = alerts.stream()
                .map(a -> new AlertResponseDTO(
                        a.getId(),
                        a.getDescription(),
                        a.getCreatedAt(),
                        a.getEntityName(),
                        a.getEntityId()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }
}
