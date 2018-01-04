package com.tcs.ct.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tcs.ct.model.UserDetails;

public interface UserRepo extends 	MongoRepository< UserDetails,  Long>{
	


}
