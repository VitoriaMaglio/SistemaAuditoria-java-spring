package com.project.auditsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuditLogResponseDTO {

    private Long id;
    private String action;
    private String entityName;
    private Long entityId;
    private String oldValue;
    private String newValue;
    private Instant createdAt;
    private String userName;


}