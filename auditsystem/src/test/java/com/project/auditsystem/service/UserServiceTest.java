package com.project.auditsystem.service;

import com.project.auditsystem.repository.UserRepository;
import com.project.auditsystem.repository.VersionedEntityRepository;
import com.project.auditsystem.service.mapper.UserSnapshotBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    private  UserRepository userRepository;

    private  AuditLogService auditLogService;
    private  AlertService alertService;
    private VersionedEntityService versionedEntityService;
    private  UserSnapshotBuilder userSnapshotBuilder;
    private  VersionedEntityRepository versionedEntityRepository;

    @Test
    @DisplayName("Should create user successfully" )
    void createUserCase1() {

    }

    @Test
    @DisplayName("Should throw exception RegisteredEmailException" )
    void createUserCase2() {
    }


}