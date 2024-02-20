package com.example.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.model.Users;
import com.example.task.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@CrossOrigin(origins = "http://localhost:4200")
	@PreAuthorize("hasAuthority('MANAGE USER')")
	@GetMapping("/all-users")
	public List<Users> getAllUsers() {
		return service.getAllUsers();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/user")
	public Users getUser(HttpServletRequest request) {
		String token = request.getHeader("Authorization").substring(7);
		return service.getUser(token);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/userid/{id}")
	public Users getUserId(@PathVariable String id) {
		return service.getUserByid(id).get();
	}
}
