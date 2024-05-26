package com.devicesManagment.demo.dto;

import com.devicesManagment.demo.entity.DeviceStatus;
import com.devicesManagment.demo.entity.DeviceType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {

    @NotBlank
    private long id;

    @NotBlank
    private DeviceType deviceType;

    @NotBlank
    private DeviceStatus deviceStatus;

    private String employeeUsername;
}
