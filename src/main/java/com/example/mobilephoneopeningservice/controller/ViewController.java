package com.example.mobilephoneopeningservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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

//    @PreAuthorize("hasRole('USER')")
////    @PreAuthorize("hasAnyAuthority({'USER', 'ADMIN'})")
//    @GetMapping("/main")
//    public String mainView() {
//        return "index";
//    }

//    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
//    @GetMapping("/openings")
//    public String openingView() {
//        return "openings";
//    }

//    @GetMapping("/customers")
//    public String customerView() {
//        return "customers";
//    }

//    @GetMapping("/users")
//    public String userView() {
//        return "users";
//    }

//    @GetMapping("/staffs")
//    public String staffView() {
//        return "staffs";
//    }
}

