package com.gcu.services;

import java.util.List;

import com.gcu.model.Product;

public interface ProductService {
    String createProduct(Product product);
    List<Product> findAll();
}
