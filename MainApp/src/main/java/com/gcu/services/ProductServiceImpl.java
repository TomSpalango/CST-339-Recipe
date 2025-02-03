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

	@Override
	public String createProduct(Product product) {
		
		productRepository.save(product); // This saves the product to the database
		return "Product saved successfully: " + product.getName();
	}
}
