package com.gcu.services;

import com.gcu.model.User;

/**
 * Service interface for handling user registration.
 * Defines the contract for registering new users.
 * 
 * @author Seline Bowens, Ty Gilbert, Tom Spalango, Robert Townsend
 */
public interface RegistrationService {

    /**
     * Registers a new user in the system.
     * 
     * @param user The user object containing registration details.
     * @return A success message if registration is successful.
     */
    String registerUser(User user);
}
