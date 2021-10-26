package com.example.mobilephoneopeningservice.repository;

import com.example.mobilephoneopeningservice.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
