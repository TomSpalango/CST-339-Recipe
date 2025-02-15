package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Spring Boot application.
 * This class bootstraps and launches the Spring Boot application.
 */
@SpringBootApplication
public class MainAppApplication {

    /**
     * Main method to start the Spring Boot application.
     * 
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(MainAppApplication.class, args); // Runs the Spring Boot application
    }
}
