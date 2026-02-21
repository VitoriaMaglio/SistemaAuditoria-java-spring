package com.project.auditsystem.dto.response;

import java.time.Instant;

public class UserSnapshotDTO {

    private final Long id;
    private final String name;
    private final String email;
    private final Boolean active;
    private final Instant createdAt;

    public UserSnapshotDTO(
            Long id,
            String name,
            String email,
            Boolean active,
            Instant createdAt
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.active = active;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Boolean getActive() { return active; }
    public Instant getCreatedAt() { return createdAt; }

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
