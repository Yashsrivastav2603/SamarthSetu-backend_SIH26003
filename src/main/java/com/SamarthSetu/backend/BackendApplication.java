package com.SamarthSetu.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner checkMongoProperty(Environment env) {
        return args -> {
            String resolved = env.getProperty("spring.data.mongodb.uri");
            System.out.println("Spring resolved spring.data.mongodb.uri exists: " + (resolved != null));
            if (resolved != null) {
                System.out.println("Spring resolved value length: " + resolved.length());
                System.out.println("Spring resolved starts with mongodb+srv://: " + resolved.startsWith("mongodb+srv://"));
            }
        };
    }
}