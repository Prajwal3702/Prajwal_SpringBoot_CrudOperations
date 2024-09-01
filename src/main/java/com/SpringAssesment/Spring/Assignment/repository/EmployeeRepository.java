package com.SpringAssesment.Spring.Assignment.repository;

import com.SpringAssesment.Spring.Assignment.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
