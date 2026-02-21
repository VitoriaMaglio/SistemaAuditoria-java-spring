package com.project.auditsystem.service.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.auditsystem.entity.User;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Responsável por gerar snapshots (JSON) do estado do User
 * para versionamento e auditoria.
 */
@Component
public class UserSnapshotBuilder {

    private final ObjectMapper objectMapper;

    public UserSnapshotBuilder(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String build(User user) {
        try {
            return objectMapper.writeValueAsString(
                    Map.of(
                            "id", user.getId(),
                            "name", user.getName(),
                            "email", user.getEmail(),
                            "active", user.getActive(),
                            "createdAt", user.getCreatedAt()
                    )
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao gerar snapshot do User", e);
        }
    }




}
