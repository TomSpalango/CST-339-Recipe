package com.gcu.services;

import com.gcu.model.Product;

public interface ProductService 
{
    String createProduct(Product product);
    String updateProduct(Product product);
    Product getProductById(Long id);
    String deleteProduct(Long id);  // New method for deleting product
}
