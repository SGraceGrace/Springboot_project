package com.example.task.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.example.task.model.Permission;
import com.example.task.model.Users;
import com.example.task.repository.RolePermissionInterface;

@Repository
public class DaoImpl {
	
	@Autowired
	MongoTemplate template;
	
	@Autowired
	RolePermissionInterface repo;
	
	public String addPermission(String permission, String email) {
		
//		Permission permission2 = repo.findByrolePermissionName(permission);
//		ObjectId permissionId = new ObjectId(permission2.getId());
//		
//		Criteria criteria = Criteria.where("email").is(email);
//		Query query = new Query(criteria);
//		
//		Update update = new Update().push("role_permission", permissionId);
//		
//		template.updateFirst(query, update, Users.class);	
		return "Success";
	}

	public void addnewPermission(Users user, Permission permission) {	
		
//		Permission permission2 = repo.findByrolePermissionName(permission.getRolePermissionName());
//		ObjectId permissionId = new ObjectId(permission2.getId());
//		
//		Criteria criteria = Criteria.where("_id").is(user.getId());
//		Query query = new Query(criteria);
//		
//		Update update = new Update().push("role_permission", permissionId);
//		
//		template.updateFirst(query, update, Users.class);
	}
}
