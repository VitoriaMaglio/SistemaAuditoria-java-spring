package com.project.auditsystem.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transaction;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false )
    private Instant createdAt;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions = new ArrayList<>();


    }

