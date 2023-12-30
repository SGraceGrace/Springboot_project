package com.example.supply_chain.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supply_chain.dao.DaoInterface;
import com.example.supply_chain.exception.SupplierNotFound;
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
		return repo.findAll();
	}
	
	public boolean existId(String SupplierUid) {		
		return repo.existsBySupplierUid(SupplierUid);
	}
	
	public Suppliers getById(String supplierUid) throws SupplierNotFound{
		Optional<Suppliers> list = repo.findBySupplierUid(supplierUid);
		
		if(list.isPresent()) 
		    return list.orElse(null);
		else
			throw new SupplierNotFound(null);
	}
	
	public void saveData(Suppliers s) {
		repo.save(s);
	}
	
	public void update(Suppliers s) {
		repo.save(s);
	}
	
	public void delete(String id) {
		Suppliers s = repo.deleteBySupplierUid(id);
	}
	
	public void updateSupplierName(String oldName,String newName) {
		dao.supplierNameUpdate(oldName, newName);
	}
	
//	public Suppliers getPhoto(String id) {
//		Optional<Suppliers> photo = repo.findBySupplierUid(id);
//		return photo.get();
//
//	}
}
