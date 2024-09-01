package com.SpringAssesment.Spring.Assignment.service.impl;

import com.SpringAssesment.Spring.Assignment.dto.EmployeeDto;
import com.SpringAssesment.Spring.Assignment.entity.Employee;
import com.SpringAssesment.Spring.Assignment.exception.ResourceNotFoundException;
import com.SpringAssesment.Spring.Assignment.mapper.EmployeeMapper;
import com.SpringAssesment.Spring.Assignment.repository.EmployeeRepository;
import io.micrometer.observation.Observation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));
        Employee employee = null;
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public <ExampleDto> EmployeeDto updateEmployee(Long employeeId, ExampleDto updateEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        {
            Observation.CheckedCallable<ResourceNotFoundException, Throwable> resourceNotFoundExceptionThrowableCheckedCallable = () -> new ResourceNotFoundException("Employee is not exists with given id:" + employeeId);
        };

        employee.setFirstName(String.valueOf(updateEmployee.getClass()));
        employee.setLastName(String.valueOf(updateEmployee.getClass()));
        employee.setEmail(String.valueOf(updateEmployee.getClass()));
        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        {
            Observation.CheckedCallable<ResourceNotFoundException, Throwable> resourceNotFoundExceptionThrowableCheckedCallable = () -> new ResourceNotFoundException("Employee is not exists with given id:" + employeeId);
        };
        employeeRepository.deleteById(employeeId);

    }

}


