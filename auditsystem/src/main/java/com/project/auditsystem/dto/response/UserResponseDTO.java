package com.project.auditsystem.dto.response;
import java.time.Instant;

public record UserResponseDTO (
     Long id,
     String name,
     String email,
     Instant created_at,
     boolean active){}
