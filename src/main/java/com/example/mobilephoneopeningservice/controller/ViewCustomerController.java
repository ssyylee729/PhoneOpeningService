package com.example.mobilephoneopeningservice.controller;

import com.example.mobilephoneopeningservice.dto.CustomerDto;
import com.example.mobilephoneopeningservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customers")
@PreAuthorize("hasRole('USER')")
public class ViewCustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public String getCustomerView(Model model){

        List<CustomerDto> customerDtoList = customerService.getCustomerDtoList();
        model.addAttribute("customerList", customerDtoList);

        return "customers";
    }
}