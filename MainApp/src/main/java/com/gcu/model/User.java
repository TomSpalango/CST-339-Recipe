package com.gcu.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Model representing a user entity.
 * Mapped to the "users" table in MySQL.
 * 
 * @author Seline Bowens, Ty Gilbert, Tom Spalango, Robert Townsend
 */
@Table("users") // Maps this class to the "users" table in the database
public class User {

    @Id
    private Long id; // Auto-generated primary key

    @NotEmpty(message = "First name is required") // Ensures first name is not empty
    private String firstName;

    @NotEmpty(message = "Last name is required") // Ensures last name is not empty
    private String lastName;

    @Email(message = "Valid email is required") // Ensures valid email format
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits") // Ensures phone number is valid
    private String phone;

    @NotEmpty(message = "Username is required") // Ensures username is not empty
    private String username;

    @Size(min = 8, message = "Password must be at least 8 characters") // Enforces password length
    private String password;

    /**
     * Default constructor (REQUIRED for Spring Data JDBC).
     */
    public User() {}

    /**
     * Constructor with all fields including ID.
     * 
     * @param id        The unique ID of the user.
     * @param firstName The first name of the user.
     * @param lastName  The last name of the user.
     * @param email     The email address of the user.
     * @param phone     The phone number of the user.
     * @param username  The username chosen by the user.
     * @param password  The hashed password of the user.
     */
    public User(Long id, String firstName, String lastName, String email, String phone, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    /**
     * Constructor without ID (used for user creation).
     * 
     * @param firstName The first name of the user.
     * @param lastName  The last name of the user.
     * @param email     The email address of the user.
     * @param phone     The phone number of the user.
     * @param username  The username chosen by the user.
     * @param password  The hashed password of the user.
     */
    public User(String firstName, String lastName, String email, String phone, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters

    /**
     * Gets the user ID.
     * 
     * @return The ID of the user.
     */
    public Long getId() { return id; }

    /**
     * Sets the user ID.
     * 
     * @param id The ID to be set.
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Gets the first name of the user.
     * 
     * @return The first name.
     */
    public String getFirstName() { return firstName; }

    /**
     * Sets the first name of the user.
     * 
     * @param firstName The first name to be set.
     */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /**
     * Gets the last name of the user.
     * 
     * @return The last name.
     */
    public String getLastName() { return lastName; }

    /**
     * Sets the last name of the user.
     * 
     * @param lastName The last name to be set.
     */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * Gets the email address of the user.
     * 
     * @return The email.
     */
    public String getEmail() { return email; }

    /**
     * Sets the email address of the user.
     * 
     * @param email The email to be set.
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Gets the phone number of the user.
     * 
     * @return The phone number.
     */
    public String getPhone() { return phone; }

    /**
     * Sets the phone number of the user.
     * 
     * @param phone The phone number to be set.
     */
    public void setPhone(String phone) { this.phone = phone; }

    /**
     * Gets the username of the user.
     * 
     * @return The username.
     */
    public String getUsername() { return username; }

    /**
     * Sets the username of the user.
     * 
     * @param username The username to be set.
     */
    public void setUsername(String username) { this.username = username; }

    /**
     * Gets the password of the user.
     * 
     * @return The password.
     */
    public String getPassword() { return password; }

    /**
     * Sets the password of the user.
     * 
     * @param password The password to be set.
     */
    public void setPassword(String password) { this.password = password; }
}
