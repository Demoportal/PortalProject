package com.tcs.ct.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tcs.ct.model.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, Integer> {
	
	
	

}
