package com.gcu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.services.RegistrationService;
import com.gcu.services.RegistrationServiceImpl;

@Configuration
public class AppConfig {
	@Bean
    public RegistrationService registrationService() {
        return new RegistrationServiceImpl();
    }
}
