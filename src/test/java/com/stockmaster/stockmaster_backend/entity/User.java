package com.stockmaster.stockmaster_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String fullName;

    // For now plain string; later you can plug in Spring Security & hashing
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.MANAGER;

    public enum Role {
        ADMIN,
        MANAGER,
        VIEWER
    }
}
