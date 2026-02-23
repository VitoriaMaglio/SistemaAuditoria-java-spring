package com.project.auditsystem.controller;

import com.project.auditsystem.dto.response.AuditLogResponseDTO;
import com.project.auditsystem.dto.response.VersionedEntityResponseDTO;
import com.project.auditsystem.entity.VersionedEntity;
import com.project.auditsystem.repository.VersionedEntityRepository;
import com.project.auditsystem.service.VersionedEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller responsável por buscar versões de uma entidade.
 */
@RestController
@RequestMapping("/versionedentity")
public class VersionedEntityController {

    @Autowired
    private VersionedEntityService versionedEntityService;

    @Autowired
    private VersionedEntityRepository versionedEntityRepository;

    public VersionedEntityController(VersionedEntityService versionedEntityService) {
        this.versionedEntityService = versionedEntityService;
    }

    @GetMapping
    public List<VersionedEntityResponseDTO> getVersions(@RequestParam String entityName,
                                                        @RequestParam Long entityId){
        return versionedEntityRepository.findByEntityNameAndEntityIdOrderByVersionDesc(entityName, entityId)
                .stream()
                .map(a -> new VersionedEntityResponseDTO(a.getId(),
                        a.getEntityName(), a.getEntityId(), a.getVersion(), a.getDataSnapshot(),a.getCreatedAt()))
                .collect(Collectors.toList());
    }
}
