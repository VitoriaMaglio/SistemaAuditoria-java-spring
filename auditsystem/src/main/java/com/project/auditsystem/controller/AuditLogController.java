package com.project.auditsystem.controller;

import com.project.auditsystem.entity.AuditLog;
import com.project.auditsystem.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Classe que representa requisições da entidade auditlog: busca de auditoria por entidade.
 */
@RestController
@RequestMapping("/auditlog")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    public AuditLogController(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @GetMapping
    public List<AuditLog> getByEntity(@RequestParam String entityName, @RequestParam Long entityId){
        return auditLogService.findByEntity(entityName,entityId);
    }

}
