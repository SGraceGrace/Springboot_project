package com.example.supply_chain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supply_chain.model.RawMaterial;
import com.example.supply_chain.repository.RawMaterialRepository;
import com.example.supply_chain.service.RawMaterialServiceInterface;

@Service
public class RawMaterialService implements RawMaterialServiceInterface{

	@Autowired
	RawMaterialRepository repo;
	
	public List<RawMaterial> getAllData(){
		List<RawMaterial> list = new ArrayList<>();
		list = repo.findAll();
		return list;
	}
	
	public List<RawMaterial> getById(long _id){
		List<RawMaterial> list = new ArrayList<>();
		list = repo.findBy_id(_id);
		return list;
	}
	
	public void saveData(RawMaterial r) {
		repo.save(r);
	}
	
	public void update(RawMaterial r) {
		repo.save(r);
	}
	
	public void delete(long _id) {
		repo.deleteBy_id(_id);
	}
}
