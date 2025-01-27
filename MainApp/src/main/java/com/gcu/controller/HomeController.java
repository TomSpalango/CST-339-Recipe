package com.cst;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("loginModel") // Store loginModel in session
public class HomeController {

    @GetMapping("/") 
    public String home(Model model) {
        // Check if loginModel exists in session/ if user is logged in)
        if (model.getAttribute("loginModel") == null) {
            return "redirect:/login"; // Redirect to login if not authenticated
        }
        
        return "home"; // If authenticated, return home page
    }
}