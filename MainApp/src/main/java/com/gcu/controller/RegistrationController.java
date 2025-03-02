package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.User;
import com.gcu.repository.UserRepository;

import jakarta.validation.Valid;

/**
 * Controller responsible for user registration functionality.
 * Handles displaying the registration form and processing user sign-ups.
 * 
 * @author Seline Bowens, Ty Gilbert, Tom Spalango, Robert Townsend
 */
@Controller
public class RegistrationController {

    private final UserRepository userRepository;

    /**
     * Constructor for injecting the UserRepository dependency.
     * 
     * @param userRepository The repository for saving user registration data.
     */
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Displays the user registration form.
     * 
     * @param model The model used to bind form data.
     * @return The "register" view template.
     */
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Initialize an empty user object for the form
        return "register";
    }

    /**
     * Handles user registration form submission.
     * 
     * @param user   The user object containing registration details.
     * @param result BindingResult for handling validation errors.
     * @param model  The model to store attributes for rendering the view.
     * @return The "register" page if there are validation errors, otherwise stays on the same page with a success message.
     */
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register"; // Reload the form with validation errors
        }

        userRepository.save(user); // Save user details in the database

        model.addAttribute("message", "Registration successful!"); // Display success message
        return "register";
    }
}
