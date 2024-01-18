package com.project.elearning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.elearning.model.User;
import com.project.elearning.repository.UserRepository;
import com.project.elearning.service.UserService;

public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repository;

	@Override
	public void add(User u) {
		repository.save(u);
		
	}

	@Override
	public boolean existsById(String userUid) {
		return repository.existsByuserUid();
	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public User getById(String userUid) {
		return repository.findByuserUid();
	}

	@Override
	public void updateUser(User u) {
		repository.save(u);
	}

	@Override
	public void deleteUser(String userUid) {
		repository.deleteByuserUid(userUid);
	}

}
