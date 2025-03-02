package com.gcu.services;

import org.springframework.stereotype.Service;
import com.gcu.model.User;
import com.gcu.repository.UserRepository;

/**
 * Service implementation for handling user registration.
 * Uses `UserRepository` to persist user data in the database.
 * 
 * @author Seline Bowens, Ty Gilbert, Tom Spalango, Robert Townsend
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;

    /**
     * Constructor for injecting the UserRepository dependency.
     * 
     * @param userRepository The repository handling user-related database operations.
     */
    public RegistrationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Registers a new user in the system.
     * 
     * @param user The user object containing registration details.
     * @return A success message indicating the user was registered.
     */
    @Override
    public String registerUser(User user) {
        userRepository.save(user); // Saves the user to the database
        return "User registered successfully: " + user.getUsername();
    }
}
