package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.gcu.model.Login;


/**
 * Controller responsible for handling login and logout functionality.
 * Manages user authentication and session attributes
 */
@Controller

public class LoginController {


	/**
     * Displays the login page.
     * 
     * @param model The model to add attributes to the login form.
     * @return The "login" view template.
     */
	
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("login", new Login()); // Initialize an empty login form.
        return "login";
    }

    /**
     * Method not needed anymore becaues Spring Security automatically processes the login form submission
     * The login form should be submittted to Spring Security's default login endpoint
     */
    
    @PostMapping("/login")
    public String processLogin(@ModelAttribute("login") Login login) {
      

        return "redirect:/"; // Spring Security should handle login and redirect automatically
    }

    /**
     * Spring Security handles logout automatically.
     */
    @GetMapping("/logout")
    public String logout() {
        
        return "redirect:/"; //Should redirect to home page after logout
    }
}
