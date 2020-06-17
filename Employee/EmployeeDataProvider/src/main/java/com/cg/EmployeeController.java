package com.cg;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeerepo;
	
	private static final Logger logger = LoggerFactory.getLogger(Employee.class);
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return employeerepo.findAll();
	}
	
	@GetMapping("/employee/{employeeId}")
	@HystrixCommand(fallbackMethod = "defaultEmployee")
	public Employee getEmployee(@PathVariable long employeeId){
		Employee tmpEmployee = employeerepo.findById(employeeId).get();
		return tmpEmployee;
	}
	
	public Employee defaultEmployee(long employeeId) {
		return new Employee();
	}
	@PostMapping(path = "/addemp")
	public Employee addEmployee(@RequestBody Employee emp) {
		return employeerepo.save(emp);
	}

	@PostMapping("/updateemp/{employeeId}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable long employeeId) {
		employeerepo.delete(employeerepo.findById(employeeId).get());
		return employeerepo.save(employee);
	}

}
