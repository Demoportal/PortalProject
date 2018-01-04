package com.tcs.ct.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tcs.ct.model.CompetencyDetails;

public interface CompetencyRepo extends MongoRepository < CompetencyDetails ,Integer>{
	
	
}
