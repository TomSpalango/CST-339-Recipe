package com.gcu.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.gcu.model.Login;

/**
 * Controller responsible for handling login and logout functionality.
 * This class manages user authentication and session attributes.
 *
 * @author Seline Bowens, Ty Gilbert, Tom Spalango, Robert Townsend
 */
@Controller
public class LoginController {

    /**
     * Displays the login page.
     *
     * @param model The model to add attributes for the login form.
     * @return The "login" view template.
     */
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "login";
    }

    /**
     * Handles user logout.
     * Spring Security automatically manages the logout process.
     *
     * @return A redirect to the home page after logout.
     */
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    /**
     * Test endpoint to verify user authentication.
     *
     * @param authentication The authentication object representing the logged-in user.
     * @return A message indicating whether the user is logged in and their username.
     */
    @GetMapping("/test-auth")
    public String testAuth(Authentication authentication) {
        if (authentication == null) {
            return "NOT LOGGED IN";
        }
        return "LOGGED IN AS: " + authentication.getName();
    }
}
