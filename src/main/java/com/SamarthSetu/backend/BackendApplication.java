package com.SamarthSetu.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {

        System.out.println("MONGODB_URI exists: "
                + (System.getenv("MONGODB_URI") != null));

        SpringApplication.run(BackendApplication.class, args);
    }
}

