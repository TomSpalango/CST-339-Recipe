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

/**
 * Application Configuration Class
 * <p>
 * Defines and provides Spring-managed beans for dependency injection, including 
 * services, repositories, and database configurations.
 * </p>
 * 
 * @author Seline Bowens, Ty Gilbert, Tom Spalango, Robert Townsend
 */
@Configuration
public class AppConfig {

    /**
     * Creates a LoginService bean.
     * <p>
     * Provides an instance of LoginServiceImpl using UserRepository 
     * for handling authentication-related operations.
     * </p>
     * 
     * @param userRepository The UserRepository dependency for authentication.
     * @return An instance of LoginServiceImpl.
     */
    @Bean
    public LoginService loginService(UserRepository userRepository) {
        return new LoginServiceImpl(userRepository);
    }
    
    /**
     * Creates a ProductService bean.
     * <p>
     * Provides an instance of ProductServiceImpl using ProductRepository 
     * for managing product-related operations.
     * </p>
     * 
     * @param productRepository The ProductRepository dependency for product management.
     * @return An instance of ProductServiceImpl.
     */
    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }

    /**
     * Creates a RegistrationService bean.
     * <p>
     * Provides an instance of RegistrationServiceImpl using UserRepository 
     * for user registration functionalities.
     * </p>
     * 
     * @param userRepository The UserRepository dependency for user registration.
     * @return An instance of RegistrationServiceImpl.
     */
    @Bean
    public RegistrationService registrationService(UserRepository userRepository) {
        return new RegistrationServiceImpl(userRepository);
    }
    
    /**
     * Configures the application's data source.
     * <p>
     * Establishes a connection to the MySQL database and configures the 
     * necessary credentials.
     * </p>
     * 
     * @return A configured DataSource for MySQL.
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/savorydatabase?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
    
    /**
     * Configures JdbcTemplate for database operations.
     * <p>
     * Simplifies interactions with the database by providing a higher-level 
     * abstraction over JDBC.
     * </p>
     * 
     * @param dataSource The DataSource dependency.
     * @return An instance of JdbcTemplate.
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
