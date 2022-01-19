package com.example.mobilephoneopeningservice.controller;

import com.example.mobilephoneopeningservice.dto.DeviceDto;
import com.example.mobilephoneopeningservice.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devices")
@Slf4j
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping
    public ResponseEntity<DeviceDto> insertNewDevice(@RequestBody DeviceDto deviceDto) {
        DeviceDto response = deviceService.insertNewDevice(deviceDto);

        return  ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<DeviceDto> updateDeviceDetail(@RequestBody DeviceDto deviceDto) {
        DeviceDto response = deviceService.updateDeviceDetail(deviceDto);

        return  ResponseEntity.ok(response);
    }

    @DeleteMapping("/{deviceId}")
    public ResponseEntity deleteDeviceByDeviceId(@PathVariable String deviceId) {
        deviceService.deleteDeviceByDeviceId(deviceId);

        return ResponseEntity.ok().build();
    }

}
