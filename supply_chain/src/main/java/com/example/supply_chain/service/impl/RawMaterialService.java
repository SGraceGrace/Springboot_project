package com.example.supply_chain.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supply_chain.dao.DaoInterface;
import com.example.supply_chain.model.RawMaterial;
import com.example.supply_chain.repository.RawMaterialRepository;
import com.example.supply_chain.service.RawMaterialServiceInterface;

@Service
public class RawMaterialService implements RawMaterialServiceInterface{

	@Autowired
	RawMaterialRepository repo;
	
	@Autowired 
	DaoInterface dao;
	
	public List<RawMaterial> getAllData(){
		List<RawMaterial> list = new ArrayList<>();
		list = repo.findAll();
		return list;
	}
	
	public RawMaterial getById(String _id){
		Optional<RawMaterial> list = repo.findById(_id);
		return list.get();
	}
	
	public boolean existId(String materialUid) {		
		return repo.existsBymaterialUid(materialUid);
	}
	
	public void saveData(RawMaterial r) {
		repo.save(r);
	}
	
	public void update(RawMaterial r) {
		dao.updateRawMaterial(r);
	}
	
	public void delete(String _id) {
		repo.deleteBy_id(_id);
	}
}
