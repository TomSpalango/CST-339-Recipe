package controller;

import org.springframework.stereotype.Service;



@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        return "user".equals(username) && "password".equals(password);
    }
}