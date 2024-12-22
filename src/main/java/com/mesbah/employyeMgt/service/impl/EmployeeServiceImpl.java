package com.mesbah.employyeMgt.service.impl;

import com.mesbah.employyeMgt.dto.EmployeeDto;
import com.mesbah.employyeMgt.entity.Employee;
import com.mesbah.employyeMgt.exception.ResourceNotFoundException;
import com.mesbah.employyeMgt.mapper.EmployeeMapper;
import com.mesbah.employyeMgt.repository.EmployeeRepository;
import com.mesbah.employyeMgt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee with this Id not found:" + employeeId));
        EmployeeDto savedEmployee = EmployeeMapper.mapToEmployeeDto(employee);
        return savedEmployee;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees;
        List<EmployeeDto> employeeDtos;
        try {
            employees = employeeRepository.findAll();
            employeeDtos = employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
            return employeeDtos;
        }
        catch (Exception e) {
            throw new ResourceNotFoundException("Employee's not found");
        }
        finally {
            employees  = null;
            employeeDtos = null;
        }

    }
}
