package com.gcu.repository;

import com.gcu.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Collections;

/**
 * Repository class responsible for database operations related to users.
 * Uses Spring JDBC (`JdbcTemplate`) to interact with the `users` table.
 * Implements `UserDetailsService` to integrate with Spring Security.
 *
 * @author Seline Bowens, Ty Gilbert, Tom Spalango, Robert Townsend
 */
@Repository
public class UserRepository implements UserDetailsService {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructor to inject JdbcTemplate dependency.
     * 
     * @param jdbcTemplate The Spring JDBC template for database interactions.
     */
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    /**
     * Loads a user by their username for authentication.
     * 
     * @param username The username to search for.
     * @return UserDetails object for Spring Security authentication.
     * @throws UsernameNotFoundException If the user is not found in the database.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList()
        );
    }

    /**
     * Finds a user by their username in the database.
     * 
     * @param username The username to search for.
     * @return The `User` object if found, otherwise `null`.
     */
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{username}, userRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;  // Return null to indicate authentication failure if no user is found
        }
    }

    /**
     * Saves a new user to the database.
     * 
     * @param user The user object to be inserted.
     * @return The number of rows affected by the insertion.
     */
    public int save(User user) {
        String sql = "INSERT INTO users (first_name, last_name, email, phone, username, password) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(), user.getUsername(), user.getPassword());
    }

    /**
     * Maps SQL result set rows to `User` objects.
     */
    private final RowMapper<User> userRowMapper = (rs, rowNum) -> new User(
            rs.getLong("id"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("email"),
            rs.getString("phone"),
            rs.getString("username"),
            rs.getString("password")
    );
}
