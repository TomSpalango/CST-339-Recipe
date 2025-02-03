package com.gcu.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.gcu.repository.ProductRepository;
import com.gcu.repository.UserRepository;
import com.gcu.services.LoginService;
import com.gcu.services.LoginServiceImpl;
import com.gcu.services.ProductService;
import com.gcu.services.ProductServiceImpl;
import com.gcu.services.RegistrationService;
import com.gcu.services.RegistrationServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public LoginService loginService(UserRepository userRepository) {
        return new LoginServiceImpl(userRepository);
    }
    
    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }

    @Bean
    public RegistrationService registrationService(UserRepository userRepository) {
        return new RegistrationServiceImpl(userRepository);
    }
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/savorydatabase?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
