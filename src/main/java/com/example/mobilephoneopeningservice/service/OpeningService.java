package com.example.mobilephoneopeningservice.service;

import com.example.mobilephoneopeningservice.domain.Customer;
import com.example.mobilephoneopeningservice.domain.Device;
import com.example.mobilephoneopeningservice.domain.Opening;
import com.example.mobilephoneopeningservice.domain.Staff;
import com.example.mobilephoneopeningservice.dto.OpeningDto;
import com.example.mobilephoneopeningservice.repository.CustomerRepository;
import com.example.mobilephoneopeningservice.repository.DeviceRepository;
import com.example.mobilephoneopeningservice.repository.OpeningRepository;
import com.example.mobilephoneopeningservice.repository.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class OpeningService {

    @Autowired
    private OpeningRepository openingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private StaffRepository staffRepository;

    public List<OpeningDto> getOpeningDtoList(){
        List<Opening> openings = openingRepository.findAll();
        log.info("openings result: {}", openings);
        List<OpeningDto> openingDtoList = openings.stream().map(OpeningDto::entityToDto).collect(Collectors.toList());
        log.info("openingDtoList result: {}", openingDtoList);
        return openingDtoList;
    }

    public List<OpeningDto> getOpeningDtoWaitingList(){
        List<Opening> openings = openingRepository.findByStatusWaiting();
        log.info("openings result: {}", openings);
        List<OpeningDto> openingDtoList = openings.stream().map(OpeningDto::entityToDto).collect(Collectors.toList());
        log.info("openingDtoList result: {}", openingDtoList);
        return openingDtoList;
    }

    public OpeningDto insertNewOpening(OpeningDto openingDto){
        Customer customer = customerRepository.findByCustomerId(openingDto.getCustomerId());
        Device device =  deviceRepository.findByDeviceId(openingDto.getDeviceId());
        Staff staff = staffRepository.findByStaffIdNotOptional(openingDto.getStaffId());

        openingDto.setCustomer(customer);
        openingDto.setDevice(device);
        openingDto.setStaff(staff);
        Opening opening = OpeningDto.dtoToEntity(openingDto);
        log.info(opening.toString());
        String customerId = opening.getCustomer().getCustomerId();
        String openingId = customerId.concat("_"+LocalDate.now());

        opening.setOpeningId(openingId);
        opening.setStatus(0);
        opening.setRequestDt(LocalDateTime.now());

        opening = openingRepository.save(opening);
        device.setRegisterStatus(1);
        deviceRepository.save(device);
        return OpeningDto.entityToDto(opening);
    }
}
