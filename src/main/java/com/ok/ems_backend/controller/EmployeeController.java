package com.ok.ems_backend.controller;

import com.ok.ems_backend.dto.EmployeeDto;
import com.ok.ems_backend.mapper.EmployeeMapper;
import com.ok.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //build add employee REST api
    @PatchMapping

    public ResponseEntity<EmployeeDto> create( @RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee= employeeService.create(employeeDto);
        return  new ResponseEntity<>(savedEmployee, HttpStatus.OK);

    };



}
