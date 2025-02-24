package com.gcu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.Product;
import com.gcu.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product API", description = "API for managing products")
public class ProductAPIController {
	
	private final ProductService productService;
	
	public ProductAPIController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	@Operation(summary = "Get all products", description = "Retrieve a list of all products")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Successfully retrieved the product list"),
		@ApiResponse(responseCode = "500", description = "Internal server error")
	})
	public List<Product> getAllProducts() {
		return productService.findAll();
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Get product by ID", description = "Retrieve a single product by its ID")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Successfully retrieved the product"),
		@ApiResponse(responseCode = "404", description = "Product not found"),
		@ApiResponse(responseCode = "500", description = "Internal server error")
	})
	public Optional<Product> getProductById(@PathVariable String id) {
		return productService.getProductById(id);
	}
}
