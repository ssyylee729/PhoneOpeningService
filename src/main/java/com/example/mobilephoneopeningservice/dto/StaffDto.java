package com.example.mobilephoneopeningservice.dto;

import com.example.mobilephoneopeningservice.domain.Staff;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StaffDto extends BaseDto{

    private Long id;
    private String staffId;
    private String name;
    private String phoneNumber;
    private String password;

    public static StaffDto entityToDto(Staff staff) {
        StaffDto staffDto = new StaffDto();
        staffDto.setId(staff.getId());
        staffDto.setStaffId(staff.getStaffId());
        staffDto.setName(staff.getName());
        staffDto.setPhoneNumber(staff.getPhoneNumber());
        staffDto.setPassword(staff.getPassword());
        staffDto.setCreatedDt(staff.getCreatedDt());
        staffDto.setUpdatedDt(staff.getUpdatedDt());
        return staffDto;
    }

    public static Staff dtoToEntity(StaffDto staffDto) {
        Staff staff = new Staff();
        staff.setName(staffDto.getName());
        staff.setStaffId(staffDto.getStaffId());
        staff.setPhoneNumber(staffDto.getPhoneNumber());
        staff.setPassword(staffDto.getPassword());
        staff.setCreatedDt(staffDto.getCreatedDt());
        staff.setUpdatedDt(staffDto.getUpdatedDt());
        return staff;
    }
}