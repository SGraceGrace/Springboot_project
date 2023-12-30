package com.example.supply_chain.service;

public interface LoginServiceInterface {

	String generateToken(String userName,String password);
	String validateToken(String token,String name);
}
