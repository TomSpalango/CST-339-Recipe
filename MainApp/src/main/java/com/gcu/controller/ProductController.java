package com.gcu.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.gcu.model.Product;
import com.gcu.services.ProductService;
import com.gcu.services.ProductServiceImpl;

import jakarta.validation.Valid;

@Controller
public class ProductController {
    
    private final ProductService productService;
    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product_list";
    }
    
    @GetMapping("/product/new")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product_form";
    }
    
    @GetMapping("/product/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isEmpty()) {
            return "redirect:/products"; // Redirect if product is not found
        }
        model.addAttribute("product", product.get());
        return "product_edit_form";
    }
    
    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return "redirect:/products";
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
    
    @PostMapping("/product/edit")
    public String updateProduct(@Valid @ModelAttribute Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "product_edit_form";
        }

        productService.updateProduct(product);
        return "redirect:/products";
    }
}
