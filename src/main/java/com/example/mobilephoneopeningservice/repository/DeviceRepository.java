package com.example.mobilephoneopeningservice.repository;

import com.example.mobilephoneopeningservice.domain.Device;
import com.example.mobilephoneopeningservice.domain.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findByName(String name);

    Page<Device> findAll(Pageable pageable);

    List<Device> findAll();

    Device findByDeviceId(String staffId);

    void deleteByDeviceId(String staffId);
}
