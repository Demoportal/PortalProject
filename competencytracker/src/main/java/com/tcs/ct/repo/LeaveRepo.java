package com.tcs.ct.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tcs.ct.model.LeaveDetails;

public interface LeaveRepo extends MongoRepository<LeaveDetails, Integer> {

}
