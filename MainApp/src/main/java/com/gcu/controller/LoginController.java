package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("loginModel")
public class LoginController 
{
	
	 private final AuthenticationService authenticationService;

	    // Constructor injection (DI)
	    @Autowired
	    public LoginController(AuthenticationService authenticationService) {
	        this.authenticationService = authenticationService;
	    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        // Create a new LoginModel instance and add it to the model
        if (!model.containsAttribute("loginModel")) { // Check if loginModel is already in the session
            model.addAttribute("loginModel", new LoginModel());
        }
        model.addAttribute("error", null); // Clear any previous error messages
        return "login"; // Return the login page (login.html)
    }

    @PostMapping("/login")
    public String processLogin(LoginModel loginModel, Model model) 
    {
        if (authenticationService.authenticate(loginModel.getUsername(), loginModel.getPassword())) 
        {
            loginModel.setAuthenticated(true);
            model.addAttribute("loginModel", loginModel);
            return "redirect:/home";
        } else 
        {
            model.addAttribute("error", "Invalid username or password");
           
            return "login";
        }

    }

    @GetMapping("/home")
    public String showHomePage() 
    {
        return "home"; //returns to home.html
    }
}