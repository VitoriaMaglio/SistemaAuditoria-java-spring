package com.project.auditsystem.service.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.auditsystem.dto.response.UserSnapshotDTO;
import com.project.auditsystem.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Responsável por gerar snapshots (JSON) do estado do User
 * para versionamento e auditoria.
 */
@Component
public class UserSnapshotBuilder {

    public String build(User user) {

        UserSnapshotDTO snapshot = new UserSnapshotDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getActive(),
                user.getCreatedAt()

        );
        return snapshot.toString();
    }}
