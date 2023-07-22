package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import java.util.List;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
@RequestMapping("api/employees")
public class DemoApplication {

	private final EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.createEmployee(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	// @RequestMapping(value = "/error", method = RequestMethod.GET)
	@GetMapping("/error")
	public String error(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Error");
	}

}
