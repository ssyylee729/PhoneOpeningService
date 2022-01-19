package com.example.mobilephoneopeningservice.controller;


import com.example.mobilephoneopeningservice.dto.OpeningDto;
import com.example.mobilephoneopeningservice.service.OpeningService;
import com.example.mobilephoneopeningservice.service.OpeningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/openings")
@PreAuthorize("hasRole('USER')")
@Slf4j
public class ViewOpeningController {

    @Autowired
    OpeningService openingService;

    @GetMapping
    public String getOpeningView(Model model){

        List<OpeningDto> openingDtoList = openingService.getOpeningDtoList();

        model.addAttribute("openingList", openingDtoList);



        return "openings";
    }
}