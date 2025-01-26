package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.gcu.model.Product;

import jakarta.validation.Valid;

@Controller
public class ProductController {
	@GetMapping("/product/new")
	public String showProductForm(Model model) {
		model.addAttribute("product", new Product());
		return "product_form";
	}
	
	@PostMapping("/product/new")
	public String createProduct(
			@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "product_form";
		}
		
		// *FOR WHEN DATABASE IS IMPLEMENTED* save product to database
		model.addAttribute("successMessage", "Product created successfully!");
		return "product_form";
	}
	
	//@GetMapping("/test")
	//@ResponseBody
	//public String test() {
	//    return "Controller is working!";
	//}
}
