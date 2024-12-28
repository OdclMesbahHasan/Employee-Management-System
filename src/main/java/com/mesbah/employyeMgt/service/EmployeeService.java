package com.mesbah.employyeMgt.service;

import com.mesbah.employyeMgt.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(EmployeeDto employeeDto, Long employeeId);
    void deleteEmployee(Long employeeId);
}
