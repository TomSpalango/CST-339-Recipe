package com.gcu.services;

import org.springframework.stereotype.Service;
import com.gcu.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public String createProduct(Product product) {
        // Simulates product creation
        return "Product created successfully: " + product.getName();
    }
}
