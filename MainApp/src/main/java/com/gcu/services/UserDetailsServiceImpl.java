package com.gcu.services;

import com.gcu.model.User;
import com.gcu.repository.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service implementation for retrieving user authentication details.
 * This service loads user-specific data and integrates with Spring Security.
 * It ensures authentication through a username and password stored in the database.
 * 
 * @author Seline Bowens, Ty Gilbert, Tom Spalango, Robert Townsend
 */
@Service
@Primary  // Ensure Spring picks this over any other UserDetailsService
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Constructor-based dependency injection for the UserRepository.
     * 
     * @param userRepository Repository for accessing user data.
     */
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Loads a user from the database and returns their authentication details.
     * This method is required by Spring Security to authenticate users.
     * 
     * @param username The username of the user attempting to log in.
     * @return UserDetails object containing user credentials and roles.
     * @throws UsernameNotFoundException if the user is not found in the database.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return org.springframework.security.core.userdetails.User.builder()
        .username(username)
        .password(user.getPassword())
        .roles("USER")
        .build();
    }
}
