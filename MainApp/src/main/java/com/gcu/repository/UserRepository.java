package com.gcu.repository;

import com.gcu.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Repository class responsible for database operations related to users.
 * Uses Spring JDBC (`JdbcTemplate`) to interact with the `users` table.
 */
@Repository
public class UserRepository {

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
     * Finds a user by their username.
     * 
     * @param username The username to search for.
     * @return The `User` object if found, otherwise returns `null`.
     */
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{username}, userRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;  // If no user is found, return null to indicate authentication failure
        }
    }

    /**
     * Saves a new user to the database.
     * 
     * @param user The user object to be inserted.
     * @return Number of rows affected.
     */
    public int save(User user) {
        String sql = "INSERT INTO users (first_name, last_name, email, phone, username, password) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(), user.getUsername(), user.getPassword());
    }

    /**
     * RowMapper for mapping SQL result set rows to `User` objects.
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
