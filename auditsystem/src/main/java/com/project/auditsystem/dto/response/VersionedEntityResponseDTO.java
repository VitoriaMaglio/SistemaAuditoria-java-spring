package com.project.auditsystem.dto.response;

import java.time.Instant;

public class VersionedEntityResponseDTO {

    private Long id;
    private String entityName;
    private Long entityId;
    private Integer version;
    private String dataSnapshot;
    private Instant createdAt;
    private String userName;
}
