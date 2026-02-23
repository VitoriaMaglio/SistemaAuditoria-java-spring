package com.project.auditsystem.dto.response;

import java.time.Instant;
public record UserSnapshotDTO(Long id, String name, String email, Boolean active, Instant createdAt) {

    public String toJson() {
        return """
            {
              "id": %d,
              "name": "%s",
              "email": "%s",
              "active": %b,
              "createdAt": "%s"
            }
            """.formatted(
                id,
                escape(name),
                escape(email),
                active,
                createdAt
        );

}

    private static String escape(String value) {
        return value == null ? "" : value.replace("\"", "\\\"");
    }}
