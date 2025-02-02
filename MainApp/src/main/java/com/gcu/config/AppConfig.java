package com.gcu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import com.gcu.repository.UserRepository;
import com.gcu.services.LoginService;
import com.gcu.services.LoginServiceImpl;
import com.gcu.services.ProductService;
import com.gcu.services.ProductServiceImpl;
import com.gcu.services.RegistrationService;
import com.gcu.services.RegistrationServiceImpl;

@Configuration
@EnableJdbcRepositories(basePackages = "com.gcu.repository")
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
    public RegistrationService registrationService(UserRepository userRepository) {
        return new RegistrationServiceImpl(userRepository);
    }
}
