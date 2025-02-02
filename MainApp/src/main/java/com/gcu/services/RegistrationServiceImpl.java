package com.gcu.services;



import org.springframework.stereotype.Service;
import com.gcu.model.User;
import com.gcu.repository.UserRepository;


@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;

    
    public RegistrationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String registerUser(User user) {
        userRepository.save(user);
        return "User registered successfully: " + user.getUsername();
    }
}
