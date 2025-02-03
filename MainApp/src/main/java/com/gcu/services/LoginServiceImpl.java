package com.gcu.services;

import com.gcu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.model.Login;
import com.gcu.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService 
{
	private final UserRepository userRepository;
	
	@Autowired
	public LoginServiceImpl(UserRepository userRepository) 
	{
		this.userRepository = userRepository;
	
	}
	


    @Override
    public boolean authenticate(Login login) 
    
    {
    	//Retrieve the user from database using username (database yet to be created)
        User user = userRepository.findByUsername(login.getUsername());
        
        
        // If user exists and the oassword matches, authentication is success
        if (user != null && user.getPassword().equals(login.getPassword())) 
        {
        	return true; //Successful login
         
        }
        	return false; // Failed login
    }
}