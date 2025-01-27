package com.gcu.services;

import com.gcu.model.Login;

public interface LoginService {
    boolean authenticate(Login login);
}
