package com.sai.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sai.entities.Employee;
import com.sai.repositories.EmployeeRepository;

@RestController
public class EmployeeResource {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/find/employee")
	@HystrixCommand(fallbackMethod="fallbackForFindEmployeeByID")
	public String findEmployeeByID(@RequestParam("id") int id) {
		Optional<Employee> optionalEmp = employeeRepository.findById(id);
		
		if(optionalEmp.isPresent()) {
			Employee emp = optionalEmp.get();
			return emp.getDesg()+", "+emp.getName();
		}else {
			return "Given id is not matched";
		}
		
	}
	
	public String fallbackForFindEmployeeByID(@RequestParam("id") int id) {
		return "desg1, name1";
	}

}
