package com.gcu.services;

import org.springframework.stereotype.Service;
import com.gcu.model.Login;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public boolean authenticate(Login login) {
        // Accept any username/password combination
        return login.getUsername() != null && login.getPassword() != null;
    }
}
