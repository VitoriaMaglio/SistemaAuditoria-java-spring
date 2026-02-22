package com.project.auditsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

import static jdk.internal.icu.impl.Utility.escape;

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
