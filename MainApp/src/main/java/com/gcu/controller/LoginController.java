package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.Login;

@Controller
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
        if ("user".equals(login.getUsername()) && "password".equals(login.getPassword())) {
            return "redirect:/";
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }
}
