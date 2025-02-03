package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.gcu.model.Product;
import com.gcu.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class ProductController {
    
    private final ProductService productService;
    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/product/new")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product_form";
    }
    
    @PostMapping("/product/new")
    public String createProduct(@Valid @ModelAttribute Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "product_form";
        }
        
        // Save the product using ProductService
        productService.createProduct(product);
        
        model.addAttribute("successMessage", "Product created successfully!");
        return "product_form";
    }
}
