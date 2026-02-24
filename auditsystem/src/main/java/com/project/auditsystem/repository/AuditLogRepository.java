package com.project.auditsystem.repository;

import com.project.auditsystem.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
        List<AuditLog> findByEntityNameAndId(String entityName, Long entityId);
        //List<AuditLog> findByUserId(Long userId);


}
