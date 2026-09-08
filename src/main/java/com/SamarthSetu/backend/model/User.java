package com.SamarthSetu.backend.model;

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
    private String email;

    @Column(nullable = false)
    private String password; // stored as a bcrypt hash, never plain text

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;       // USER or CAREGIVER

    // filled in during one-time profile setup, empty right after signup
    private String fullName;
    private Integer age;
    private String gender;
    private String mobileNumber;

    private boolean profileCompleted = false;

    public enum Role {
        USER, CAREGIVER
    }
}