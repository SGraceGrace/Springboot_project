package com.example.task.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.task.model.Role;
import com.example.task.model.RolePermission;

public interface RolePermissionInterface extends MongoRepository<RolePermission, String>{

	List<RolePermission> findByRole(Role role);

}
