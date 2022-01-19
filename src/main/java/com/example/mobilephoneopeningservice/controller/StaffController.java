package com.example.mobilephoneopeningservice.controller;

import com.example.mobilephoneopeningservice.domain.Staff;
import com.example.mobilephoneopeningservice.dto.CustomerDto;
import com.example.mobilephoneopeningservice.dto.StaffDto;
import com.example.mobilephoneopeningservice.service.StaffService;
import com.example.mobilephoneopeningservice.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staffs")
@Slf4j
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/name")
    public ResponseEntity<String> getLoginName(@AuthenticationPrincipal User user){
        Staff staff = (Staff) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userId = staff.getStaffId();
        String userName = staffService.findLoginName(userId);
        return ResponseEntity.ok(userName);
    }

    @GetMapping("/list")
    public ResponseEntity<List<StaffDto>> getStaffListByPageNo(@RequestParam int pageNo, @RequestParam int pageSize){
        List<StaffDto> staffDtoList = staffService.findAllByPage(pageNo, pageSize);
        return ResponseEntity.ok(staffDtoList);
    }


    @GetMapping
    public ResponseEntity<List<StaffDto>> getStaffListAll(){
        List<StaffDto> staffDtoList = staffService.getstaffDtoList();
        return ResponseEntity.ok(staffDtoList);
    }

    @PostMapping
    public ResponseEntity<StaffDto> insertNewStaff(@RequestBody StaffDto staffDto) {
        StaffDto staffDtoResponse = staffService.insertNewStaff(staffDto);
        return  ResponseEntity.ok(staffDtoResponse);
    }

    @PutMapping
    public ResponseEntity<StaffDto> updateStaffDetail(@RequestBody StaffDto staffDto) {
        StaffDto staffDtoResponse = staffService.updateStaffDetail(staffDto);
        return  ResponseEntity.ok(staffDtoResponse);
    }

    @DeleteMapping("/{staffId}")
    public ResponseEntity deleteStaffByStaffId(@PathVariable String staffId) {
        staffService.deleteStaffByStaffId(staffId);
        return ResponseEntity.ok().build();
    }
}
