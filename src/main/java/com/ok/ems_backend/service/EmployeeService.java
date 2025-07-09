package com.ok.ems_backend.service;

import com.ok.ems_backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto create(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployeeDto);
    void deleteEmployee(Long id);
}
