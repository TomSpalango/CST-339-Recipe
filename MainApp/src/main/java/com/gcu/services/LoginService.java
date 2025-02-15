package com.gcu.services;

import com.gcu.model.Login;

/**
 * Service interface for handling user authentication.
 * Defines the contract for login validation.
 */
public interface LoginService {

    /**
     * Authenticates a user based on login credentials.
     * 
     * @param login The login object containing the username and password.
     * @return `true` if authentication is successful, `false` otherwise.
     */
    boolean authenticate(Login login);
}
