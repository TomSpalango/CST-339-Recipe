package com.gcu.services;

import com.gcu.model.User;
import com.gcu.model.Login;
import com.gcu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for handling user authentication.
 * Uses the UserRepository to validate login credentials.
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
     * Authenticates a user based on login credentials.
     * 
     * @param login The login object containing the username and password.
     * @return `true` if authentication is successful, `false` otherwise.
     */
    @Override
    public boolean authenticate(Login login) {
        // Retrieve the user from the database using the provided username
        User user = userRepository.findByUsername(login.getUsername());

        // If user exists and the password matches, authentication is successful
        if (user != null && user.getPassword().equals(login.getPassword())) {
            return true; // Successful login
        }

        return false; // Failed login
    }
}
