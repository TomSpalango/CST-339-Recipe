package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.gcu.model.Login;
import com.gcu.services.LoginService;

@Controller
@SessionAttributes("username")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        // Add a new Login instance to the model if it's not already present
        if (!model.containsAttribute("login")) {
            model.addAttribute("login", new Login());
        }
        model.addAttribute("error", null); // Clear any previous error messages
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("login") Login login, Model model) {
        if (loginService.authenticate(login)) {
            // Store the username in the session
            model.addAttribute("username", login.getUsername());
            return "redirect:/"; // Redirect to the index.html (root "/")
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        // Clear the session attributes
        status.setComplete();
        return "redirect:/"; // Redirect to the index.html (root "/") after logout
    }
}
