package com.example.mobilephoneopeningservice.controller;

import com.example.mobilephoneopeningservice.dto.OpeningDto;
import com.example.mobilephoneopeningservice.service.OpeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/main")
@PreAuthorize("hasRole('USER')")
public class ViewMainController {

    @Autowired
    OpeningService openingService;

    @GetMapping
    public String getMainView(Model model){
        List<OpeningDto> openingDtoList = openingService.getOpeningDtoWaitingList();
        int totalCnt = openingService.getOpeningDtoList().size();
        int waitingCnt = openingDtoList.size();
        model.addAttribute("openingList", openingDtoList);
        model.addAttribute("totalCnt", totalCnt);
        model.addAttribute("waitingCnt", waitingCnt);
        model.addAttribute("completedCnt", totalCnt - waitingCnt);
        return "index";
    }
}