package com.gcu.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class User {
	
	
	@NotEmpty(message = "First name is required")
	private String firstName;
	
	@NotEmpty(message = "Last name is required")
    private String lastName;
	
	@Email(message = "Valid Email is required")
    private String email;
	
	@NotEmpty(message = "Phone number is required")
    private String phone;
	
	@NotEmpty(message = "Username is required")
    private String username;
	 
	 @NotEmpty(message = "Password is required")
    private String password;
}