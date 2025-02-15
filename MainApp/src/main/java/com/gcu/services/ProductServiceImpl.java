package com.gcu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.gcu.model.Product;
import com.gcu.repository.ProductRepository;

/**
 * Service implementation for handling product-related operations.
 * Uses `ProductRepository` to interact with the database.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    /**
     * Constructor for injecting the ProductRepository dependency.
     * 
     * @param productRepository The repository handling product-related database operations.
     */
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Retrieves a product by its unique ID.
     * 
     * @param id The ID of the product.
     * @return An `Optional<Product>` containing the product if found, otherwise empty.
     */
    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    /**
     * Creates a new product in the system.
     * 
     * @param product The product object to be created.
     * @return A success message if the product is added successfully.
     */
    @Override
    public String createProduct(Product product) {
        productRepository.save(product); // Saves to the database
        return "Product saved successfully: " + product.getName();
    }

    /**
     * Retrieves all products from the system.
     * 
     * @return A list of all products.
     */
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * Updates an existing product in the system.
     * 
     * @param product The updated product object.
     * @return A success message if the product is updated successfully, otherwise an error message.
     */
    @Override
    public String updateProduct(Product product) {
        int rowsAffected = productRepository.update(product);
        return (rowsAffected > 0) ? "Product updated successfully!" : "Product update failed!";
    }

    /**
     * Deletes a product by its ID.
     * 
     * @param id The ID of the product to delete.
     * @return A success message if the product is deleted, otherwise an error message.
     */
    @Override
    public String deleteProduct(String id) {
        int rowsAffected = productRepository.delete(id);
        return (rowsAffected > 0) ? "Product deleted successfully" : "Product not found or already deleted.";
    }
}
