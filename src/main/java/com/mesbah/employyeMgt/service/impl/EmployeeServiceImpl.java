package com.mesbah.employyeMgt.service.impl;

import com.mesbah.employyeMgt.dto.EmployeeDto;
import com.mesbah.employyeMgt.entity.Employee;
import com.mesbah.employyeMgt.mapper.EmployeeMapper;
import com.mesbah.employyeMgt.repository.EmployeeRepository;
import com.mesbah.employyeMgt.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }
}
