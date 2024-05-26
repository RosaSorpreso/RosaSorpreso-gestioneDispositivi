package com.devicesManagment.demo.repository;

import com.devicesManagment.demo.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
