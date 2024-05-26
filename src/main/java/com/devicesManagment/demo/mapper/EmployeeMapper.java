package com.devicesManagment.demo.mapper;

import com.devicesManagment.demo.dto.EmployeeDTO;
import com.devicesManagment.demo.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "id", ignore = true)
    Employee toEntity(EmployeeDTO employeeDTO);
}
