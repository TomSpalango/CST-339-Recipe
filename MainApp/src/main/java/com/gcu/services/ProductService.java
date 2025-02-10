package com.gcu.services;

import java.util.List;
import java.util.Optional;

import com.gcu.model.Product;

public interface ProductService 
{
    String createProduct(Product product);

    List<Product> findAll();
    String updateProduct(Product product);
    Optional<Product> getProductById(String id);
    String deleteProduct(String id); 

}
