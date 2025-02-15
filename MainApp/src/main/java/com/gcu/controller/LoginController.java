package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.gcu.model.Login;
import com.gcu.model.User;
import com.gcu.repository.UserRepository;

/**
 * Controller responsible for handling login and logout functionality.
 * Manages user authentication and session attributes.
 */
@Controller
@SessionAttributes("username")
public class LoginController {

    private final UserRepository userRepository;

    /**
     * Constructor to inject UserRepository dependency.
     * 
     * @param userRepository The repository used for user authentication.
     */
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
     * Processes the login form submission.
     * 
     * @param login The login form model containing username and password.
     * @param model The model to add session attributes.
     * @return Redirects to the home page if login is successful, otherwise reloads the login page.
     */
    @PostMapping("/login")
    public String processLogin(@ModelAttribute("login") Login login, Model model) {
        User user = userRepository.findByUsername(login.getUsername());

        // Validate username and password
        if (user == null || !user.getPassword().equals(login.getPassword())) {
            model.addAttribute("error", "Invalid username or password"); // Adds error message
            return "login"; // Reload login page
        }

        // Store username in session
        model.addAttribute("username", user.getUsername());

        return "redirect:/?reload=true"; // Redirect to homepage after successful login
    }

    /**
     * Logs the user out by clearing session attributes.
     * 
     * @param status The session status used to mark the session as complete.
     * @return Redirects to the home page after logout.
     */
    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete(); // Clears the session attributes
        return "redirect:/";
    }
}
