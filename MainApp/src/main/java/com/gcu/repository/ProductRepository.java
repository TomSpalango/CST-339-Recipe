package com.gcu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcu.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
