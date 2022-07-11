package com.example.demoProjectService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demoProjectService.model.Employee;
import com.example.demoProjectService.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("{eid}")
	public Employee getEmployee(@PathVariable("eid") int eid) {
		return employeeService.getEmployeeById(eid);
	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		System.out.println(employee);
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/list")
	public List<Employee> getEmployees() {
		return employeeService.getEmployeeList();
	}

	@PutMapping("{eid}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("eid") int eid,
			@RequestBody Employee employeeDetails) {
		Employee employee = employeeService.getEmployeeById(eid);
		System.out.println(employee);
		employee.setEname(employeeDetails.getEname());
		employee.setSalary(employeeDetails.getSalary());
		Employee updatedEmployee = employeeService.saveEmployee(employee);
		System.out.println(updatedEmployee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("{eid}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(@PathVariable int eid) {
		Employee employee = employeeService.getEmployeeById(eid);
		employeeService.deleteEmployee(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Employee successfully deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
