package com.SamarthSetu.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String email;
    private String password; // stored as a bcrypt hash, never plain text
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