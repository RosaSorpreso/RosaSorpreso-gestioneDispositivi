package com.devicesManagment.demo.mapper;

import com.devicesManagment.demo.dto.DeviceDTO;
import com.devicesManagment.demo.entity.Device;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceMapper {

    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employee", ignore = true)
    Device toEntity(DeviceDTO deviceDTO);
}
