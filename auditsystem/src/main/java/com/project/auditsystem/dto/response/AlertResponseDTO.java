package com.project.auditsystem.dto.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

public record AlertResponseDTO (
     Long id,
     String description,
     Instant created_at,
     String entityName,
     Long entityId){}
