package com.example.supply_chain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supply_chain.dao.DaoInterface;
import com.example.supply_chain.model.Suppliers;
import com.example.supply_chain.repository.SuppliersRepository;
import com.example.supply_chain.service.SupplierServiceInterface;

@Service
public class SupplierService implements SupplierServiceInterface{

	@Autowired
	SuppliersRepository repo;
	
	@Autowired
	DaoInterface dao;
	
	public List<Suppliers> getAllData(){
		List<Suppliers> list = new ArrayList<>();
		list = repo.findAll();
		return list;
	}
	
	public List<Suppliers> getById(long _id){
		List<Suppliers> list = new ArrayList<>();
		list = repo.findBy_id(_id);
		return list;
	}
	
	public void saveData(Suppliers s) {
		repo.save(s);
	}
	
	public void update(Suppliers s) {
		repo.save(s);
	}
	
	public void delete(long _id) {
		repo.deleteBy_id(_id);
	}
	
	public void updateSupplierName(String oldName,String newName) {
		dao.supplierNameUpdate(oldName, newName);
	}
}
