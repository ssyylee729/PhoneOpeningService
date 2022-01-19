package com.example.mobilephoneopeningservice.controller;

import com.example.mobilephoneopeningservice.dto.StaffDto;
import com.example.mobilephoneopeningservice.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/staffs")
@PreAuthorize("hasRole('ADMIN')")
public class ViewStaffController {

    @Autowired
    StaffService staffService;

    @GetMapping
    public String getStaffView(Model model){

        List<StaffDto> staffDtoList = staffService.getstaffDtoList();
        model.addAttribute("staffList", staffDtoList);

        return "staffs";
    }
}