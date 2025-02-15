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

import jakarta.validation.Valid;

/**
 * Controller responsible for managing product-related operations.
 * Handles product listing, creation, editing, and deletion.
 */
@Controller
public class ProductController {
    
    private final ProductService productService;

    /**
     * Constructor for injecting ProductService dependency.
     * 
     * @param productService The service layer handling product-related logic.
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Displays the list of products.
     * 
     * @param model The model to store attributes for the view.
     * @return The "product_list" view template displaying all products.
     */
    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product_list";
    }

    /**
     * Displays the form for creating a new product.
     * 
     * @param model The model to store attributes for the form.
     * @return The "product_form" view template.
     */
    @GetMapping("/product/new")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product()); // Initializes a blank product object
        return "product_form";
    }

    /**
     * Displays the form for editing an existing product.
     * 
     * @param id    The ID of the product to edit.
     * @param model The model to store attributes for the form.
     * @return The "product_edit_form" view template if the product exists, otherwise redirects to the product list.
     */
    @GetMapping("/product/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isEmpty()) {
            return "redirect:/products"; // Redirect if product is not found
        }
        model.addAttribute("product", product.get());
        return "product_edit_form";
    }

    /**
     * Deletes a product by ID.
     * 
     * @param id The ID of the product to delete.
     * @return Redirects to the product list page after deletion.
     */
    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    /**
     * Handles product creation form submission.
     * 
     * @param product The product object with form data.
     * @param result  BindingResult to handle validation errors.
     * @param model   The model to store attributes for the view.
     * @return Redirects to the product list page if successful, otherwise reloads the form.
     */
    @PostMapping("/product/new")
    public String createProduct(@Valid @ModelAttribute Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "product_form"; // Reload the form with validation errors
        }

        // Save the product
        productService.createProduct(product);
        return "redirect:/products"; // Redirect to product list after creation
    }

    /**
     * Handles product update form submission.
     * 
     * @param product The updated product object.
     * @param result  BindingResult to handle validation errors.
     * @param model   The model to store attributes for the view.
     * @return Redirects to the product list page if successful, otherwise reloads the edit form.
     */
    @PostMapping("/product/edit")
    public String updateProduct(@Valid @ModelAttribute Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "product_edit_form"; // Reload the edit form with validation errors
        }

        productService.updateProduct(product);
        return "redirect:/products"; // Redirect to product list after update
    }
}
