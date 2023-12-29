package com.example.supply_chain.service.impl;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.*;

@Service
public class LoginService {

	public String generateToken(String userName,String password) {
		Claims claims = Jwts.claims().setSubject(userName);
		//System.out.println("claims :"+claims);
		String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, "test").compact();
		// System.out.println("token :"+token);
		return token;
		
	}
	
	public String generatePasswordToken(String userName,String password) {
		Claims claims = Jwts.claims().setSubject(userName);
		//System.out.println("claims :"+claims);
		String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, "test").compact();
		// System.out.println("token :"+token);
		return token;
		
	}
	
	public String validateToken(String token,String name){
		// System.out.println("token :"+token);
        if(token.equals(generateToken(name, ""))){
            return "Valid";
        }
        return "Invalid";
    }
}
