package com.example.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.dto.LoginDTO;
import com.example.task.dto.ResponseDTO;
import com.example.task.dto.SignupDTO;
import com.example.task.jwtservice.JwtService;
import com.example.task.service.AuthService;

@RestController
public class AuthController {

	@Autowired
	JwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	AuthService service;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/signup")
	public ResponseDTO signup(@RequestBody SignupDTO signupDTO){
		System.out.println("yes");
		return service.signup(signupDTO);	
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public ResponseDTO login(@RequestBody LoginDTO loginDTO) throws Exception{
		return service.login(loginDTO);
	}

}

