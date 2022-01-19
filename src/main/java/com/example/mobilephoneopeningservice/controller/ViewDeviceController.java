package com.example.mobilephoneopeningservice.controller;

import com.example.mobilephoneopeningservice.dto.CustomerDto;
import com.example.mobilephoneopeningservice.dto.DeviceDto;
import com.example.mobilephoneopeningservice.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/devices")
@PreAuthorize("hasRole('USER')")
public class ViewDeviceController {

    @Autowired
    DeviceService deviceService;

    @GetMapping
    public String getDeviceView(Model model){
        List<DeviceDto> deviceDtoList = deviceService.getDeviceDtoList();
        model.addAttribute("deviceList", deviceDtoList);

        return "devices";
    }
}