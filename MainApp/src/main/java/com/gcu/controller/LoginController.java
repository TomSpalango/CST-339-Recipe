package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.gcu.model.Login;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("username")
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@Valid @ModelAttribute Login login, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "login";
        }
        // Accept any username/password
        model.addAttribute("username", login.getUsername());
        System.out.println("Logged in as: " + login.getUsername()); // Debug log
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }
}
