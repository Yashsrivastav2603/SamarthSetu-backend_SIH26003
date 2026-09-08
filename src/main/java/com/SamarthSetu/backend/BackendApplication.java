package com.SamarthSetu.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        String mongoUri = System.getenv("MONGODB_URI");

        System.out.println("MONGODB_URI exists: " + (mongoUri != null));
        if (mongoUri != null) {
            System.out.println("MONGODB_URI length: " + mongoUri.length());
            System.out.println("MONGODB_URI starts with mongodb+srv://: " + mongoUri.startsWith("mongodb+srv://"));
        }

        SpringApplication.run(BackendApplication.class, args);
    }
}
