package com.gcu.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * Model representing login credentials.
 * This class is used to capture user input for authentication.
 * 
 * @author Seline Bowens, Ty Gilbert, Tom Spalango, Robert Townsend
 */
public class Login {

    /**
     * The username for login.
     * It must not be empty and should have a minimum length of 4 characters.
     */
    @NotEmpty(message = "Username is required")
    @Size(min = 4, message = "Username must be at least 4 characters long")
    private String username;

    /**
     * The password for login.
     * It must not be empty.
     */
    @NotEmpty(message = "Password is required")
    private String password;

    /**
     * Default constructor.
     */
    public Login() {
    }

    /**
     * Constructor with parameters.
     * 
     * @param username The username for login.
     * @param password The password for login.
     */
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username.
     * 
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     * 
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     * 
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * 
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
