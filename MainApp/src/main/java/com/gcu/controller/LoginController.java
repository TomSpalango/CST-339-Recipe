package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import controller.LoginModel;  // Import the LoginModel class

@Controller
public class LoginController 
{

    @GetMapping("/login")
    public String showLoginPage(Model model) 
    {
        // Create a new LoginModel instance and add it to the model
        model.addAttribute("loginModel", new Login());
        model.addAttribute("error", null);
        return "login";  // Return the login page (login.html)
    }

    @PostMapping("/login")
    public String processLogin(Login loginModel, Model model) 
    {
        // Simulate user authentication
        if ("user".equals(loginModel.getUsername()) && "password".equals(loginModel.getPassword())) 
        {
            loginModel.setAuthenticated(true);  // Set the authentication flag
            return "redirect:/home";  // Redirect to the home page if successful
        } else {
            model.addAttribute("error", "Invalid username or password");
            model.addAttribute("loginModel", loginModel);  // Pass the LoginModel back to the login page
            return "login";  // Return to the login page with an error
        }
    }

    @GetMapping("/home")
    public String showHomePage() 
    {
        return "home"; //returns to home.html
    }
}