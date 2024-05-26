package com.devicesManagment.demo.service;

import com.devicesManagment.demo.dto.DeviceDTO;
import com.devicesManagment.demo.entity.Device;
import com.devicesManagment.demo.errorHandling.ResourceNotFoundException;
import com.devicesManagment.demo.mapper.DeviceMapper;
import com.devicesManagment.demo.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> findAll() {return deviceRepository.findAll();}

    public Optional<Device> findById(Long id){return deviceRepository.findById(id);}

    public Device save(DeviceDTO deviceDTO){
        Device device = DeviceMapper.INSTANCE.toEntity(deviceDTO);
        return deviceRepository.save(device);
    }

    public Device update(DeviceDTO deviceDTO){
        if (!deviceRepository.existsById(deviceDTO.getId())){
            throw new ResourceNotFoundException("Device with provided id: " + deviceDTO.getId() + " not found");
        }
        Device device = DeviceMapper.INSTANCE.toEntity(deviceDTO);
        return deviceRepository.save(device);
    }

    public void deleteById(Long id){
        if (!deviceRepository.existsById(id)){
            throw new ResourceNotFoundException("Device not found with provided id: " + id);
        }
        deviceRepository.deleteById(id);
    }
}
