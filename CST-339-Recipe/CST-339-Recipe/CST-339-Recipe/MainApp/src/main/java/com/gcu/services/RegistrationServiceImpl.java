package com.gcu.services;

public class RegistrationServiceImpl implements RegistrationService {
	@Override
    public String registerUser(User user) {
        
        return "Registration successful for user: " + user.getUsername();
    }
}
