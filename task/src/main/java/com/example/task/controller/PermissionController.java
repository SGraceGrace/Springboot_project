package com.example.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.service.PermissionService;

@RestController
public class PermissionController {

	@Autowired
	PermissionService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/add-permission/{permission}/{email}")
	public String addPermissions(@PathVariable String permission, @PathVariable String email) {
		return service.addPermission(permission.toUpperCase(), email);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/add-new-permission/{permissionName}")
	public String addNewPermission(@PathVariable String permissionName) {
		return service.addNewPermission(permissionName);
	}
}
