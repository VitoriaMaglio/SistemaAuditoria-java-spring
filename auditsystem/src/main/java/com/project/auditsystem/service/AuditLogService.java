package com.project.auditsystem.service;
import com.project.auditsystem.entity.AuditLog;
import com.project.auditsystem.entity.User;
import com.project.auditsystem.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service que contém a lógica de negócio para criação de auditoria das entidades do sistema.
 */
@Service
public class AuditLogService {
    @Autowired
    private AuditLogRepository auditLogRepository;

    public AuditLogService(){}

    //Registra uma ação no sistema
    public void logAction(String action, String entityName, Long entityId, String oldValue, String newValue, User user) {
        AuditLog auditLog = new AuditLog();
        auditLog.setAction(action);
        auditLog.setEntityName(entityName);
        auditLog.setEntityId(entityId);
        auditLog.setOldValue(oldValue);
        auditLog.setNewValue(newValue);
        auditLog.setUser(user);
        auditLogRepository.save(auditLog);
    }
    public List<AuditLog> findByEntity(String entityName, Long entityId){
        return auditLogRepository.findByEntityNameAndId(entityName,entityId);
    }
    //AuditLog é chamado por user e transaction service para auditar as ações(gerar registros imutáveis)
}
