package com.ok.ems_backend.service.impl;

import com.ok.ems_backend.dto.EmployeeDto;
import com.ok.ems_backend.entity.Employee;
import com.ok.ems_backend.mapper.EmployeeMapper;
import com.ok.ems_backend.repository.EmployeeRepository;
import com.ok.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl  implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {

        Employee  employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=  employeeRepository.save(employee);



        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
     Employee employee=employeeRepository.findById(employeeId)
            .orElseThrow(()->
                    new RuntimeException("Employee not found with id: " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List <Employee> employees= employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployeeDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        // Update the existing employee's fields with the new values
         employee.setFirstName(updatedEmployeeDto.getFirstName());
         employee.setLastName(updatedEmployeeDto.getLastName());
         employee.setEmail(updatedEmployeeDto.getEmail());


          Employee updatedEmployeeObj= employeeRepository.save(employee);



        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        employeeRepository.delete(employee);









    }
}
