package com.example.supply_chain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supply_chain.dao.DaoInterface;
import com.example.supply_chain.model.Style;
import com.example.supply_chain.repository.StyleRepository;
import com.example.supply_chain.service.StyleServiceInterface;

@Service
public class StyleService implements StyleServiceInterface{
	
	@Autowired
	StyleRepository repo;
	
	@Autowired
	DaoInterface dao;;

	public List<Style> getAllStyle(){		
		List<Style> list = new ArrayList<>();
		list = repo.findAll();
		return list;		
	}
	
	public List<Style> getById(long _id){
		List<Style> list = new ArrayList<>();
		list = repo.findBy_id(_id);
		return list;
	}
	
	public void addData(Style s) {
		repo.save(s);
	}
	
	public void updateData(Style s) {
		repo.save(s);
	}
	
	public void deleteData(long _id) {
		repo.deleteBy_id(_id);
	}
	
	public List<Style> getAllData(){
		return dao.getAllData();
		
	}
}

