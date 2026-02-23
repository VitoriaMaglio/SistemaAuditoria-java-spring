package com.project.auditsystem.controller;

import com.project.auditsystem.dto.response.AlertResponseDTO;
import com.project.auditsystem.dto.response.AuditLogResponseDTO;
import com.project.auditsystem.entity.Alert;
import com.project.auditsystem.entity.AuditLog;
import com.project.auditsystem.repository.AlertRepository;
import com.project.auditsystem.repository.AuditLogRepository;
import com.project.auditsystem.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe que representa requisições da entidade auditlog: busca de auditoria por entidade.
 */
@RestController
@RequestMapping("/auditlog")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    @Autowired
    private AuditLogRepository auditLogRepository;

    public AuditLogController(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @GetMapping
    public List<AuditLogResponseDTO> getByEntity(@RequestParam String entityName, @RequestParam Long entityId){
        return auditLogRepository.findByEntityNameAndId(entityName, entityId)
                .stream()
                .map(a -> new AuditLogResponseDTO(a.getId(), a.getAction(),
                        a.getEntityName(), a.getEntityId(), a.getOldValue(), a.getNewValue(),a.getCreatedAt()))
                .collect(Collectors.toList());
    }

}
