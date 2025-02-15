package com.gcu.repository;

import com.gcu.model.Product;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository class responsible for database operations related to products.
 * Uses Spring JDBC (`JdbcTemplate`) to interact with the `products` table.
 */
@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructor to inject JdbcTemplate dependency.
     * 
     * @param jdbcTemplate The Spring JDBC template for database interactions.
     */
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Saves a new product to the database.
     * 
     * @param product The product object to be inserted.
     * @return Number of rows affected.
     */
    public int save(Product product) {
        String sql = "INSERT INTO products (name, quantity, price, description) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, product.getName(), product.getQuantity(), product.getPrice(), product.getDescription());
    }

    /**
     * Updates an existing product in the database.
     * 
     * @param product The updated product object.
     * @return Number of rows affected.
     * @throws IllegalArgumentException if the product does not exist.
     */
    public int update(Product product) {
        String sql = "UPDATE products SET name = ?, quantity = ?, price = ?, description = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, product.getName(), product.getQuantity(), product.getPrice(), product.getDescription(), product.getId());

        if (rowsAffected == 0) {
            throw new IllegalArgumentException("Product with ID " + product.getId() + " does not exist.");
        }

        return rowsAffected;
    }

    /**
     * Finds a product by its ID.
     * 
     * @param id The product ID.
     * @return An `Optional<Product>` containing the product if found, otherwise empty.
     */
    public Optional<Product> findById(String id) {
        String sql  = "SELECT * FROM products WHERE id = ?";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, productRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();  // Return an empty Optional if no product is found
        }
    }

    /**
     * Retrieves all products from the database.
     * 
     * @return A list of all products.
     */
    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, productRowMapper);
    }

    /**
     * Deletes a product by ID.
     * 
     * @param id The ID of the product to delete.
     * @return Number of rows affected.
     */
    public int delete(String id) {
        String sql = "DELETE FROM products WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    /**
     * RowMapper for mapping SQL result set rows to Product objects.
     */
    private final RowMapper<Product> productRowMapper = (rs, rowNum) -> new Product(
        rs.getLong("id"),
        rs.getString("name"),
        rs.getInt("quantity"),
        rs.getDouble("price"),
        rs.getString("description")
    );
}
