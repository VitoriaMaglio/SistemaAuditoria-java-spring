package com.project.auditsystem.dto.response;

import java.time.Instant;

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
