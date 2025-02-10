package com.gcu.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.gcu.model.Product;
import com.gcu.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    
    public ProductServiceImpl(ProductRepository productRepository) {
    	this.productRepository = productRepository;
    }
    @Override
    public Product getProductById(String id) {
    	return productRepository.findById(id);
    }

	@Override
	public String createProduct(Product product) {
		
		productRepository.save(product); // This saves the product to the database
		return "Product saved successfully: " + product.getName();
	}

	@Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
	
	@Override
	public String updateProduct(Product product) {
		int rowsAffected = productRepository.update(product);
		return (rowsAffected > 0) ? "Product updated successfully!" : "Product update failed!";
	}
	
	@Override
	public String deleteProduct(String id) {
		int rowsAffected = productRepository.delete(id);
		return (rowsAffected > 0) ? "Product deleted successfully" : "Product deletion failed";
	}


}
