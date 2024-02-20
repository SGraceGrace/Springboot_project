package com.example.task.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.task.model.Users;

public interface UserRepository extends MongoRepository<Users, String>{

	Users findByemail(String email);
	boolean existsByemail(String email);

}
