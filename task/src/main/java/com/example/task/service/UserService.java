package com.example.task.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.task.dao.DaoImpl;
import com.example.task.jwtservice.JwtService;
import com.example.task.model.Users;
import com.example.task.repository.UserRepository;
@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	@Autowired
	DaoImpl dao;
	
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public List<Users> getAllUsers() {
		List<Users> users = repository.findAll();
			return users;
	}

	public Users getUser(String token) {
		String email = jwtService.extractUsername(token);
		Users user = repository.findByemail(email);
				
			return user;
	}

	public Optional<Users> getUserByid(String id) {
		return Optional.ofNullable(repository.findById(id).get());
	}
}

