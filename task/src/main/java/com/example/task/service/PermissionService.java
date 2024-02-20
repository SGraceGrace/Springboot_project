package com.example.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.dao.DaoImpl;
import com.example.task.repository.RolePermissionInterface;
import com.example.task.repository.UserRepository;

@Service
public class PermissionService {

	@Autowired
	DaoImpl dao;
	
	@Autowired
	RolePermissionInterface repo;
	
	@Autowired
	UserRepository repository;
	
	public String addPermission(String permission, String email) {
		return dao.addPermission(permission, email);
	}
	
	public String addNewPermission(String permissionName) {
//		RolePermission permission = Permission.builder().rolePermissionName(permissionName.toUpperCase()).build();
//		repo.save(permission);
//		
//		List<Users> list = repository.findAll();
//		for(Users user: list) {
//			if(user.getRole().getRoleName().equals("ADMIN")) {
//				dao.addnewPermission(user, permission);
//			}
//		}
		return "success";
	}
}
