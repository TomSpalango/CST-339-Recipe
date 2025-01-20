package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // Maps the root URL (http://localhost:8080/) to this method
    public String home() {
        return "home"; // This should match the name of your Thymeleaf template: home.html
    }
}