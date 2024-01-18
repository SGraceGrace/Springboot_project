package com.project.elearning.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.elearning.model.User;

public interface UserRepository extends MongoRepository<User, String>{

	boolean existsByuserUid();

	User findByuserUid();

	void deleteByuserUid(String userUid);

}
