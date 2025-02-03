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

@Controller
@SessionAttributes("username")
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("login") Login login, Model model) {
        User user = userRepository.findByUsername(login.getUsername());
        if (user != null && user.getPassword().equals(login.getPassword())) {
            model.addAttribute("username", user.getUsername());
            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }
}
