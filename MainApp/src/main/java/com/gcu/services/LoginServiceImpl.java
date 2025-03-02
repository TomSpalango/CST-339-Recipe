package com.gcu.services;

import com.gcu.model.User;
import com.gcu.model.Login;
import com.gcu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the LoginService interface.
 * This service handles user authentication by verifying credentials against the database.
 * 
 * @author Seline Bowens, Ty Gilbert, Tom Spalango, Robert Townsend
 */
@Service
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    /**
     * Constructor for injecting the UserRepository dependency.
     * 
     * @param userRepository The repository used to retrieve user authentication data.
     */
    @Autowired
    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Authenticates a user based on provided login credentials.
     * This method checks if a user exists in the database with the given username
     * and verifies if the provided password matches the stored password.
     * 
     * @param login The login object containing the username and password.
     * @return {@code true} if authentication is successful, {@code false} otherwise.
     */
    @Override
    public boolean authenticate(Login login) {
        // Retrieve the user from the database using the provided username
        User user = userRepository.findByUsername(login.getUsername());

        // If user exists and the password matches, authentication is successful
        return user != null && user.getPassword().equals(login.getPassword());
    }
}
