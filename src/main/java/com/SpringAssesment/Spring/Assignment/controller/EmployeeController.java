package com.SpringAssesment.Spring.Assignment.controller;

import com.SpringAssesment.Spring.Assignment.dto.EmployeeDto;
import com.SpringAssesment.Spring.Assignment.service.impl.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    //Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    //Build Get Employee REST Api
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(Long employee){
        Long employeeId = null;
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);

        return ResponseEntity.ok(employeeDto);
    }
    //Build Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employee = employeeService.getAllEmployees();
        return ResponseEntity.ok(employee);
    }
    //Build update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updateEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updateEmployee);
        return ResponseEntity.ok(employeeDto);
    }
    //Build Delete Employee REST API
    @DeleteMapping({"id"})
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully!.");
    }
}
