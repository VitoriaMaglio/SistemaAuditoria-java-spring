package com.project.auditsystem.controller;

import com.project.auditsystem.entity.VersionedEntity;
import com.project.auditsystem.service.VersionedEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller responsável por buscar versões de uma entidade.
 */
@RestController
@RequestMapping("/versionedentity")
public class VersionedEntityController {

    @Autowired
    private VersionedEntityService versionedEntityService;

    public VersionedEntityController(VersionedEntityService versionedEntityService) {
        this.versionedEntityService = versionedEntityService;
    }

    @GetMapping
    public List<VersionedEntity> getVersions(@RequestParam String entityName,
                                             @RequestParam Long entityId){
        return versionedEntityService.getVersions(entityName,entityId);
    }
}
