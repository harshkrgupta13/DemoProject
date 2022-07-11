package com.example.demoProjectService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demoProjectService.exception.ResourceNotFoundException;
import com.example.demoProjectService.model.Employee;
import com.example.demoProjectService.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public Employee getEmployeeById(int eid) {
		return employeeRepository.findById(eid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with given id: " + eid));
	}

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getEmployeeList() {
		return employeeRepository.findAll();
	}

	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
	}
}
