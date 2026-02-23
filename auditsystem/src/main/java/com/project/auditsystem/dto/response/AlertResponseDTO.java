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
public class AlertResponseDTO {

    private Long id;
    private String description;
    private Instant created_at;
    private String entityName;
    private Long entityId;



}
