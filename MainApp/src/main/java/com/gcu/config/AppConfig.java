package com.gcu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.services.LoginService;
import com.gcu.services.LoginServiceImpl;
import com.gcu.services.ProductService;
import com.gcu.services.ProductServiceImpl;
import com.gcu.services.RegistrationService;
import com.gcu.services.RegistrationServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public LoginService loginService() {
        return new LoginServiceImpl();
    }

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl();
    }

    @Bean
    public RegistrationService registrationService() {
        return new RegistrationServiceImpl();
    }
}
