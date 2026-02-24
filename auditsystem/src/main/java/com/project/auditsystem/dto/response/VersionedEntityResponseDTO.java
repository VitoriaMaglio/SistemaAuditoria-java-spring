package com.project.auditsystem.dto.response;


import java.time.Instant;

public record VersionedEntityResponseDTO (

     Long id,
     String entityName,
     Long entityId,
     Integer version,
    String dataSnapshot,
    Instant createdAt)
{}
