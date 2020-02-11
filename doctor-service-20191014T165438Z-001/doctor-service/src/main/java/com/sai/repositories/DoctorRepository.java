package com.sai.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sai.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer>{

	Optional<Doctor> findByName(String name);
	
}
