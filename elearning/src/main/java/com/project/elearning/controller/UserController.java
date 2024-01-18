package com.project.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.elearning.model.User;
import com.project.elearning.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService service;

	@PostMapping("add-user")
	public ResponseEntity<String> saveUser(@RequestBody User u) {

		try {
			boolean check = service.existsById(u.getUserUid());

			if (check) {
				return new ResponseEntity<>("Already Exists", HttpStatus.FORBIDDEN);
			} else {
				service.add(u);
				return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("all-users")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			List<User> users = service.getAllUsers();
			if (users != null) {
				return new ResponseEntity<>(users, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("user/{userUid}")
	public ResponseEntity<User> getById(@PathVariable String userUId) {
		try {
			User user = service.getById(userUId);
			if (user != null) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("update-user")
	public ResponseEntity<String> updateUser(@RequestBody User u){
		try {
			boolean check = service.existsById(u.getUserUid());

			if (check) {
				service.updateUser(u);
				return new ResponseEntity<>("Updated Successfully", HttpStatus.FORBIDDEN);
			} else {
				return new ResponseEntity<>("User Not Exists", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("delete-user")
	public ResponseEntity<String> deleteUser(@PathVariable String userUId){
		try {
			boolean check = service.existsById(userUId);

			if (check) {
				service.deleteUser(userUId);
				return new ResponseEntity<>("Deleted Successfully", HttpStatus.FORBIDDEN);
			} else {
				return new ResponseEntity<>("User Not Exists", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
