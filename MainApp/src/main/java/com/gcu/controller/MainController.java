package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class MainController {

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("title", "Welcome to SavoryScript");
        return "index";
    }
}
