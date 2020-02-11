package com.sai.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sai.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{

	Optional<Employee> findById(int id);
	
}
