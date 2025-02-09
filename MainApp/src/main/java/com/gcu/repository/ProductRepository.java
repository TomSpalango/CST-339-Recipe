package com.gcu.repository;

import com.gcu.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Insert new product into database
    public int save(Product product) {
        String sql = "INSERT INTO products (id, name, quantity, price, description) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, product.getName(), product.getQuantity(), product.getPrice(), product.getDescription());
    }

    // Retrieve all products
    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, productRowMapper);
    }

    private final RowMapper<Product> productRowMapper = (rs, rowNum) -> new Product(
        rs.getLong("id"),
        rs.getString("name"),
        rs.getInt("quantity"),
        rs.getDouble("price"),
        rs.getString("description")
    );
}
