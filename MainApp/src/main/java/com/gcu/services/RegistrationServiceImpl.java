package com.gcu.services;

import org.springframework.stereotype.Service;
import com.gcu.model.User;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Override
    public String registerUser(User user) {
        // For demonstration purposes, simulate user registration
        return "User registered successfully: " + user.getUsername();
    }
}
