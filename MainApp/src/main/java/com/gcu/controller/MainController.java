package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Controller responsible for handling requests to the main page.
 * Ensures that the homepage (`/`) is accessible.
 */
@Controller
@SessionAttributes("username") // Retains the username session attribute for logged-in users.
public class MainController {

    /**
     * Handles requests to the home page (`/`).
     * 
     * @param model The model to store attributes needed for rendering the view.
     * @return The "index" view template.
     */
    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("title", "Welcome to SavoryScript");
        return "index"; // Loads the home page
    }
}
