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

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }


    // Refatoração: removida a conversão de entidade para DTO do controller.
    // O service agora retorna os DTOs prontos usando Mapper,
    // mantendo o controller focado apenas em responsabilidade HTTP.
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<AlertResponseDTO>> getAlertsByUser(@PathVariable Long userId){
        List<AlertResponseDTO> alertsDto = alertService.findAlertsByUser(userId);
        return ResponseEntity.ok(alertsDto);
    }
}
