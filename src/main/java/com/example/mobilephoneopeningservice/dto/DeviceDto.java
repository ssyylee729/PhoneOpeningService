package com.example.mobilephoneopeningservice.dto;

import com.example.mobilephoneopeningservice.domain.Device;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class DeviceDto extends BaseDto{

    private Long id;
    private String deviceId;
    private String name;
    private String registeredDt;
    private int registerStatus;

    public static DeviceDto entityToDto(Device device) {
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setId(device.getId());
        deviceDto.setDeviceId(device.getDeviceId());
        deviceDto.setName(device.getName());
        deviceDto.setRegisteredDt(device.getRegisteredDt());
        deviceDto.setRegisterStatus(device.getRegisterStatus());
        deviceDto.setCreatedDt(device.getCreatedDt());
        deviceDto.setUpdatedDt(device.getUpdatedDt());
        return deviceDto;
    }

    public static Device dtoToEntity(DeviceDto deviceDto) {
        Device device = new Device();
        device.setDeviceId(deviceDto.getDeviceId());
        device.setName(deviceDto.getName());
        device.setRegisteredDt(deviceDto.getRegisteredDt());
        device.setRegisterStatus(deviceDto.getRegisterStatus());
        device.setCreatedDt(deviceDto.getCreatedDt());
        device.setUpdatedDt(deviceDto.getUpdatedDt());
        return device;
    }
}