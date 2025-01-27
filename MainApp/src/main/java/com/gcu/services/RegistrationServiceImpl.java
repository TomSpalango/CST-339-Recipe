package com.gcu.services;

import com.gcu.model.User;

public class RegistrationServiceImpl implements RegistrationService {
	@Override
    public String registerUser(User user) {
        
        return "Registration successful for user: " + user.getUsername();
    }
}
