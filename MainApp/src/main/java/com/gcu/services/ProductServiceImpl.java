package com.gcu.services;

import org.springframework.stereotype.Service;
import com.gcu.model.Product;
import com.gcu.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    
    public ProductServiceImpl(ProductRepository productRepository) {
    	this.productRepository = productRepository;
    }
    
    public Product getProductById(Long id) {
    	return productRepository.findById(id);
    }

	@Override
	public String createProduct(Product product) {
		
		productRepository.save(product); // This saves the product to the database
		return "Product saved successfully: " + product.getName();
	}
	
	@Override
	public String updateProduct(Product product) {
		int rowsAffected = productRepository.update(product);
		return (rowsAffected > 0) ? "Product updated successfully!" : "Product update failed!";
	}
	
	@Override
	public String deleteProduct(Long id) {
		int rowsAffected = productRepository.delete(id); //For delete product module
		return (rowsAffected > 0) ? "Product deleted successfully" : "Product deletion failed";
	}
}
