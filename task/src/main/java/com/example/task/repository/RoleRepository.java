package com.example.task.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.task.model.Role;

public interface RoleRepository extends MongoRepository<Role, String>{

	Role findByroleName(String string);

}
