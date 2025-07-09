package com.ok.ems_backend.controller;

import com.ok.ems_backend.dto.EmployeeDto;
//import com.ok.ems_backend.mapper.EmployeeMapper;
import com.ok.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //build add employee REST ap
   @PostMapping

    public ResponseEntity<EmployeeDto> create( @RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee= employeeService.create(employeeDto);
        return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }

    //build get employee by id REST api

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);

    }
    //build get all employees REST api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
         List<EmployeeDto> employees= employeeService.getAllEmployees();
         return ResponseEntity.ok(employees);

    }

    //build update employee REST api
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto updatedEmployeeDto) {
        EmployeeDto employee = employeeService.updateEmployee(id, updatedEmployeeDto);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    //build delete employee REST api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }

}
