package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.User;
import com.gcu.services.RegistrationService;
import jakarta.validation.Valid;

@Controller
public class RegistrationController {
	
	private final RegistrationService registrationService;
	
	 @Autowired
	    public RegistrationController(RegistrationService registrationService) {
	        this.registrationService = registrationService;
	    }
	 
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        
        String message = registrationService.registerUser(user);
        model.addAttribute("message", "Registration successful!");
        return "register";
    }
}
