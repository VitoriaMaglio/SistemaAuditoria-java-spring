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
public class VersionedEntityResponseDTO {

    private Long id;
    private String entityName;
    private Long entityId;
    private Integer version;
    private String dataSnapshot;
    private Instant createdAt;



}
