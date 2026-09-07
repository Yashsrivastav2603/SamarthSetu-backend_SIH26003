package com.SamarthSetu.backend.controller;

import com.SamarthSetu.backend.dto.LoginRequest;
import com.SamarthSetu.backend.dto.SignupRequest;
import com.SamarthSetu.backend.model.User;
import com.SamarthSetu.backend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest request) {
        User user = authService.signup(request);
        return ResponseEntity.ok().body(
                new java.util.HashMap<>() {{
                    put("id", user.getId());
                    put("email", user.getEmail());
                    put("role", user.getRole());
                    put("profileCompleted", user.isProfileCompleted());
                }}
        );
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}