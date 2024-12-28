package com.mesbah.employyeMgt.repository;

import com.mesbah.employyeMgt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeById(Long id);
}
