package com.example.mobilephoneopeningservice.service;

import com.example.mobilephoneopeningservice.domain.Customer;
import com.example.mobilephoneopeningservice.domain.Staff;
import com.example.mobilephoneopeningservice.domain.Staff;
import com.example.mobilephoneopeningservice.dto.CustomerDto;
import com.example.mobilephoneopeningservice.dto.StaffDto;
import com.example.mobilephoneopeningservice.dto.StaffDto;
import com.example.mobilephoneopeningservice.repository.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public String findLoginName(String staffId){
        Staff staff = staffRepository.findNameByStaffId(staffId);
        return staff.getName();
    }
    public List<StaffDto> findAllByPage(int pageNo, int pageSize){
        List<Staff> staffs = staffRepository.findAll(PageRequest.of(pageNo, pageSize)).toList();
        List<StaffDto> staffDtoList = staffs.stream().map(StaffDto::entityToDto).collect(Collectors.toList());
        return staffDtoList;
    }

    public StaffDto insertNewStaff(StaffDto staffDto){
        Staff staff = StaffDto.dtoToEntity(staffDto);
        staff = staffRepository.save(staff);

        return StaffDto.entityToDto(staff);
    }

    public StaffDto updateStaffDetail(StaffDto staffDto){
        Long id = staffRepository.findByStaffId(staffDto.getStaffId()).get().getId();
        Staff staff = StaffDto.dtoToEntity(staffDto);
        staff.setId(id);
        staff = staffRepository.save(staff);

        return StaffDto.entityToDto(staff);
    }

    public void deleteStaffByStaffId(String staffId){
        staffRepository.deleteByStaffId(staffId);
    }

    public List<StaffDto> getstaffDtoList(){
        List<Staff> staffs = staffRepository.findAll();
        List<StaffDto> staffDtoList = staffs.stream().map(StaffDto::entityToDto).collect(Collectors.toList());
        return staffDtoList;
    }
}
