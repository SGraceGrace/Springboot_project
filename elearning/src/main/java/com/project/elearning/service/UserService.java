package com.project.elearning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.elearning.model.User;

@Service
public interface UserService {

	void add(User u);
	boolean existsById(String userUid);
	List<User> getAllUsers();
	User getById(String userUid);
	void updateUser(User u);
	void deleteUser(String userUid);
}
