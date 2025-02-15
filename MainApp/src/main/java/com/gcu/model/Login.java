package com.gcu.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * Model representing login credentials.
 * Used for validating user authentication input.
 */
public class Login {

    @NotEmpty(message = "Username is required") // Ensures username is not empty
    private String username;

    @NotEmpty(message = "Password is required") // Ensures password is not empty
    @Size(min = 8, message = "Password must be at least 8 characters") // Enforces minimum password length
    private String password;

    /**
     * Gets the username.
     * 
     * @return The username entered by the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     * 
     * @param username The username to be set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     * 
     * @return The password entered by the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * 
     * @param password The password to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
