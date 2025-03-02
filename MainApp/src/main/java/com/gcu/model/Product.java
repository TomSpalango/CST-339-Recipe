package com.gcu.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Model representing a product entity.
 * Mapped to the "products" table in MySQL.
 * 
 * @author Seline Bowens, Ty Gilbert, Tom Spalango, Robert Townsend
 */
@Table("products") // Mapping to MySQL table "products"
public class Product {
    
    @Id
    private Long id;
    
    @NotBlank(message = "Product name cannot be blank.") // Ensures name is not empty
    @Size(max = 100, message = "Product name cannot exceed 100 characters.") // Limits name length
    private String name;
    
    @Min(value = 0, message = "Must have quantity of at least 0.") // Ensures quantity is non-negative
    private int quantity;
    
    @Min(value = 0, message = "Must have a price of at least 0.") // Ensures price is non-negative
    private double price;
    
    @Size(max = 500, message = "Description cannot exceed 500 characters.") // Limits description length
    private String description;

    /**
     * Default constructor (REQUIRED for Spring Data JDBC).
     */
    public Product() {}

    /**
     * Parameterized constructor for creating a product instance.
     * 
     * @param id          The unique ID of the product.
     * @param name        The name of the product.
     * @param quantity    The quantity available.
     * @param price       The price of the product.
     * @param description The description of the product.
     */
    public Product(Long id, String name, int quantity, double price, String description) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    // Getters and Setters

    /**
     * Gets the product ID.
     * 
     * @return The ID of the product.
     */
    public Long getId() { return id; }

    /**
     * Sets the product ID.
     * 
     * @param id The ID to be set.
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Gets the product name.
     * 
     * @return The name of the product.
     */
    public String getName() { return name; }

    /**
     * Sets the product name.
     * 
     * @param name The name to be set.
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets the product quantity.
     * 
     * @return The quantity of the product.
     */
    public int getQuantity() { return quantity; }

    /**
     * Sets the product quantity.
     * 
     * @param quantity The quantity to be set.
     */
    public void setQuantity(int quantity) { this.quantity = quantity; }

    /**
     * Gets the product price.
     * 
     * @return The price of the product.
     */
    public double getPrice() { return price; }

    /**
     * Sets the product price.
     * 
     * @param price The price to be set.
     */
    public void setPrice(double price) { this.price = price; }

    /**
     * Gets the product description.
     * 
     * @return The description of the product.
     */
    public String getDescription() { return description; }

    /**
     * Sets the product description.
     * 
     * @param description The description to be set.
     */
    public void setDescription(String description) { this.description = description; }
}
