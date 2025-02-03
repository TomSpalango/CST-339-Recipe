package com.gcu.repository;

import com.gcu.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Retrieve user by username
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, userRowMapper);
    }

    // Save user to database
    public int save(User user) {
        String sql = "INSERT INTO users (first_name, last_name, email, phone, username, password) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(), user.getUsername(), user.getPassword());
    }

    // Map database columns to User object
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
