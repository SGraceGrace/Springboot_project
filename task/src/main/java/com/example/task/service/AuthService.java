package com.example.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.task.dto.LoginDTO;
import com.example.task.dto.ResponseDTO;
import com.example.task.dto.SignupDTO;
import com.example.task.jwtservice.JwtService;
import com.example.task.model.Role;
import com.example.task.model.RolePermission;
import com.example.task.model.Users;
import com.example.task.repository.RolePermissionInterface;
import com.example.task.repository.RoleRepository;
import com.example.task.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	UserRepository repo;

	@Autowired
	JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	RoleRepository repository;
	
	@Autowired
	RolePermissionInterface repoInterface;

	public ResponseDTO signup(SignupDTO signupDTO) {
		Users user;
		String token = "";

		if (signupDTO.getEmail().contains("admin")) {
			
			Role role = repository.findByroleName("ADMIN");		
			List<RolePermission> permission = repoInterface.findByRole(role);
			
			System.out.println(permission);
			
			user = Users.builder().name(signupDTO.getName()).password(passwordEncoder.encode(signupDTO.getPassword()))
					.email(signupDTO.getEmail()).role(role).rolePermissions(permission).build();
		} else {
			
			Role role = repository.findByroleName("USER");
			List<RolePermission> permission = repoInterface.findByRole(role);
			
			System.out.println(permission);
			
			user = Users.builder().name(signupDTO.getName()).password(passwordEncoder.encode(signupDTO.getPassword()))
					.email(signupDTO.getEmail()).role(role).rolePermissions(permission)
					.build();
		}

		repo.save(user);
		token = jwtService.generateToken(user);

		return ResponseDTO.builder().accessToken(token).build();
	}

	public ResponseDTO login(LoginDTO loginDTO) throws Exception {
		System.out.println(loginDTO);
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
			Users user = repo.findByemail(loginDTO.getEmail());
			System.out.println(user);
			String token = jwtService.generateToken(user);
			return ResponseDTO.builder().accessToken(token).build();
		} catch (BadCredentialsException | UsernameNotFoundException e) {
			throw new Exception();
		}
	}
}
