package com.example.mobilephoneopeningservice.service;

import com.example.mobilephoneopeningservice.domain.Device;
import com.example.mobilephoneopeningservice.dto.DeviceDto;
import com.example.mobilephoneopeningservice.repository.DeviceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public DeviceDto insertNewDevice(DeviceDto deviceDto){
        Device device = DeviceDto.dtoToEntity(deviceDto);
        device = deviceRepository.save(device);

        return DeviceDto.entityToDto(device);
    }

    public DeviceDto updateDeviceDetail(DeviceDto deviceDto){
        Long id = deviceRepository.findByDeviceId(deviceDto.getDeviceId()).getId();
        Device device = DeviceDto.dtoToEntity(deviceDto);
        device.setId(id);
        device = deviceRepository.save(device);

        return DeviceDto.entityToDto(device);
    }

    public void deleteDeviceByDeviceId(String deviceId){
        deviceRepository.deleteByDeviceId(deviceId);
    }

    public List<DeviceDto> getDeviceDtoList(){
        List<Device> devices = deviceRepository.findAll();
        return devices.stream().map(DeviceDto::entityToDto).collect(Collectors.toList());
    }

}
