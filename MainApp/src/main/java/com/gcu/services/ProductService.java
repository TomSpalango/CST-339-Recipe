package com.gcu.services;

import java.util.List;
import java.util.Optional;
import com.gcu.model.Product;

/**
 * Service interface for handling product-related operations.
 * Defines the contract for creating, retrieving, updating, and deleting products.
 * 
 * @author Seline Bowens, Ty Gilbert, Tom Spalango, Robert Townsend
 */
public interface ProductService {

    /**
     * Creates a new product in the system.
     * 
     * @param product The product object to be created.
     * @return A success message if the product is added successfully.
     */
    String createProduct(Product product);

    /**
     * Retrieves all products from the system.
     * 
     * @return A list of all products.
     */
    List<Product> findAll();

    /**
     * Updates an existing product.
     * 
     * @param product The updated product object.
     * @return A success message if the product is updated successfully.
     */
    String updateProduct(Product product);

    /**
     * Retrieves a product by its unique ID.
     * 
     * @param id The ID of the product.
     * @return An `Optional<Product>` containing the product if found, otherwise empty.
     */
    Optional<Product> getProductById(String id);

    /**
     * Deletes a product by its ID.
     * 
     * @param id The ID of the product to delete.
     * @return A success message if the product is deleted successfully.
     */
    String deleteProduct(String id);
}
