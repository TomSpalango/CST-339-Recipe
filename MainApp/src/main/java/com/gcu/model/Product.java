package com.gcu.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Product {
	private Long id;
	
	@NotBlank(message = "Product name cannot be blank")
	@Size(max = 100, message = "Product name cannot exceed length of 100 characters")
	private String name;
	
	@Min(value = 0, message = "Must have quantity of atleast 0")
	private int quantity;
	
	@Min(value = 0, message = "Must have price of atleast 0")
	private double price;
	
	@Size(max = 500, message = "Description cannot exceed length of 500 characters")
	private String description;
	
	// Getters and Setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
	    return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
