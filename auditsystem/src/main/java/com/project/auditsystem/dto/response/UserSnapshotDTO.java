package com.project.auditsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@AllArgsConstructor

@Getter
@Setter
public class UserSnapshotDTO {

    private final Long id;
    private final String name;
    private final String email;
    private final Boolean active;
    private final Instant createdAt;


    @Override
    public String toString() {
        return "UserSnapshotDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", createdAt=" + createdAt +
                '}';
    }
}
