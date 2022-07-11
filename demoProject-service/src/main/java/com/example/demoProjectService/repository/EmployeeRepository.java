package com.example.demoProjectService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoProjectService.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
