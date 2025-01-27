package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gcu.model.Login;
import com.gcu.services.LoginService;

@Controller
@SessionAttributes("username")
public class LoginController {

    private final LoginService loginService;

    // Constructor injection (DI)
    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        // Create a new Login instance and add it to the model
        if (!model.containsAttribute("login")) {
            model.addAttribute("login", new Login());
        }
        model.addAttribute("error", null); // Clear any previous error messages
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("login") Login login, Model model) {
        if (loginService.authenticate(login)) {
            model.addAttribute("username", login.getUsername());
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home"; // Return home.html
    }
}
