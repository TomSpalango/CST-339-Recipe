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
    
    // Update/edit an existing product
    public int update(Product product) {
    	String sql = "UPDATE products SET name = ?, quantity = ?, price = ?, description = ? WHERE id = ?";
    	return jdbcTemplate.update(sql, product.getName(), product.getQuantity(), product.getPrice(), product.getDescription(), product.getId());
    }

    public Product findById(String id) {
    	String sql  = "SELECT * FROM products WHERE id = ?";
    	return jdbcTemplate.queryForObject(sql,  productRowMapper, id);
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
    public int delete(String id) {
    	String sql = "Delete from products where id = ?";
    	return jdbcTemplate.update(sql, id);
    }
}
