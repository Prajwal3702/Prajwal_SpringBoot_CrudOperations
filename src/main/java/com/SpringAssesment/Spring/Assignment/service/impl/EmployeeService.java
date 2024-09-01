package com.SpringAssesment.Spring.Assignment.service.impl;

import com.SpringAssesment.Spring.Assignment.dto.EmployeeDto;
import  com.SpringAssesment.Spring.Assignment.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
    <ExampleDto> EmployeeDto updateEmployee(Long employeeId, ExampleDto updateEmployee);
    void deleteEmployee(Long employeeId);
}
