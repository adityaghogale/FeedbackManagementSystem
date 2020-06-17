package com.cg;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "false")
@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository proxy;
	private static final Logger logger = LoggerFactory.getLogger(Employee.class);
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return proxy.getAllEmployee();
	}
	
	@GetMapping("/employee/{employeeId}")
	public Optional<Employee> getEmployee(@PathVariable long employeeId){
		return proxy.getEmployee(employeeId);
	}
	
	
}
