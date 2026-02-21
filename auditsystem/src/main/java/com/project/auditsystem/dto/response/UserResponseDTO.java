package com.project.auditsystem.dto.response;

import com.project.auditsystem.dto.request.UserRequestDTO;
import com.project.auditsystem.entity.User;

import java.time.Instant;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private Instant created_at;
    private boolean active;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
