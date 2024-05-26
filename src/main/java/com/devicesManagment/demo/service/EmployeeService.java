package com.devicesManagment.demo.service;

import com.devicesManagment.demo.dto.EmployeeDTO;
import com.devicesManagment.demo.entity.Employee;
import com.devicesManagment.demo.errorHandling.ResourceNotFoundException;
import com.devicesManagment.demo.mapper.EmployeeMapper;
import com.devicesManagment.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll(){return employeeRepository.findAll();}

    public Optional<Employee> findById(Long id){return employeeRepository.findById(id);}

    public Employee save(EmployeeDTO employeeDTO){
        Employee employee = EmployeeMapper.INSTANCE.toEntity(employeeDTO);
        return employeeRepository.save(employee);
    }

    public Employee update(EmployeeDTO employeeDTO){
        if (!employeeRepository.existsById(employeeDTO.getId())){
            throw new ResourceNotFoundException("Employee with id " + employeeDTO.getId() + " not found");
        }
        Employee employee = EmployeeMapper.INSTANCE.toEntity(employeeDTO);
        return employeeRepository.save(employee);
    }

    public void deleteById(Long id){
        if (!employeeRepository.existsById(id)){
            throw new ResourceNotFoundException("Employee with id " + id + " not found");
        }
        employeeRepository.deleteById(id);
    }
}
