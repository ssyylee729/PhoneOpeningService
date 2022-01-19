package com.example.mobilephoneopeningservice.dto;

import com.example.mobilephoneopeningservice.domain.Customer;
import com.example.mobilephoneopeningservice.domain.Device;
import com.example.mobilephoneopeningservice.domain.Opening;
import com.example.mobilephoneopeningservice.domain.Staff;
import com.example.mobilephoneopeningservice.repository.CustomerRepository;
import com.example.mobilephoneopeningservice.repository.DeviceRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Component
public class OpeningDto extends BaseDto{

    private Long id;
    private String openingId;
    private LocalDateTime requestDt;
    private int status;
    private String deviceId;
    private String customerId;
    private String staffId;
    private Customer customer;
    private Device device;
    private Staff staff;

//    public OpeningDto(DeviceRepository deviceRepository, CustomerRepository customerRepository){
//        this.deviceRepository = deviceRepository;
//        this.customerRepository = customerRepository;
//    }

    public static OpeningDto entityToDto(Opening opening) {
        OpeningDto openingDto = new OpeningDto();
        openingDto.setId(opening.getId());
        openingDto.setOpeningId(opening.getOpeningId());
        openingDto.setRequestDt(opening.getRequestDt());
        openingDto.setStatus(opening.getStatus());
        openingDto.setCreatedDt(opening.getCreatedDt());
        openingDto.setUpdatedDt(opening.getUpdatedDt());
        openingDto.setCustomerId(opening.getCustomer().getCustomerId());
        openingDto.setDeviceId(opening.getDevice().getDeviceId());
        openingDto.setStaffId(opening.getStaff().getStaffId());

        return openingDto;
    }

    public static Opening dtoToEntity(OpeningDto openingDto) {
        Opening opening = new Opening();
        opening.setOpeningId(openingDto.getOpeningId());
        opening.setRequestDt(openingDto.getRequestDt());
        opening.setStatus(openingDto.getStatus());
        opening.setCreatedDt(openingDto.getCreatedDt());
        opening.setUpdatedDt(openingDto.getUpdatedDt());
        opening.setCustomer(openingDto.getCustomer());
        opening.setDevice(openingDto.getDevice());
        opening.setStaff(openingDto.getStaff());
        return opening;
    }
}