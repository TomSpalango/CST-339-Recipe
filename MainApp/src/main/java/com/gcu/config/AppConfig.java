package com.gcu.config;

import com.gcu.services.RegistrationService;
import com.gcu.services.RegistrationServiceImpl;

@Configuration
public class AppConfig {
	@Bean
    public RegistrationService registrationService() {
        return new RegistrationServiceImpl();
    }
}
