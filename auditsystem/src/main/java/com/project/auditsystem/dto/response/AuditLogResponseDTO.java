package com.project.auditsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

public record AuditLogResponseDTO (

     Long id,
     String action,
     String entityName,
     Long entityId,
     String oldValue,
     String newValue,
     Instant createdAt)
{}