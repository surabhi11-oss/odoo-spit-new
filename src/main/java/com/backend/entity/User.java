package com.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔹 you already had this:
    @Column(nullable = false, unique = true)
    private String username;

    // 🔹 make sure this exists:
    @Column(nullable = false)
    private String name;

    // 🔹 add this field so setEmail()/getEmail() exist
    @Column(nullable = false, unique = true)
    private String email;

    // optional extras – only if you are using them
    private String role;
    private String password;
}
