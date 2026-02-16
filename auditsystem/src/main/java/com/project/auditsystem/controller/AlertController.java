package com.project.auditsystem.controller;

import com.project.auditsystem.dto.response.AlertResponseDTO;
import com.project.auditsystem.entity.Alert;
import com.project.auditsystem.service.AlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    private AlertService alertService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Alert>> getAlertsByUser(@PathVariable Long userId){
        return ResponseEntity.ok(alertService.findAlertsByUser(userId));
    }
}
