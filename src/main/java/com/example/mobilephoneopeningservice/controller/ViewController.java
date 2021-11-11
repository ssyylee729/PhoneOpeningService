package com.example.mobilephoneopeningservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }
    @GetMapping("/main")
    public String mainView() {
        return "index";
    }

    @GetMapping("/openings")
    public String openingView() {
        return "openings";
    }

    @GetMapping("/customers")
    public String customerView() {
        return "customers";
    }

    @GetMapping("/users")
    public String userView() {
        return "users";
    }
}

