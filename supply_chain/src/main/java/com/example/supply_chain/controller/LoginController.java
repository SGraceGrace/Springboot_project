package com.example.supply_chain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.supply_chain.service.impl.LoginService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

	@Autowired
	LoginService login;
	
	@PostMapping("/login")
	public String login(@RequestParam String userName , @RequestParam String password) {
		
		return login.generateToken(userName, password);
	}
	
	@GetMapping("/verifyName")
    public String getMethodName(HttpServletRequest request, @RequestParam String name) {
		//System.out.println("test:"+request.getHeader("Authorization"));
		 return login.validateToken(request.getHeader("Authorization").split(" ",2)[1],name);
    }

}
