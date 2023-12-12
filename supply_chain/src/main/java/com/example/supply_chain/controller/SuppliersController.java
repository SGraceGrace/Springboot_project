package com.example.supply_chain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.supply_chain.model.Suppliers;
import com.example.supply_chain.service.SupplierServiceInterface;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {

	@Autowired
	SupplierServiceInterface service;
	
	@GetMapping("/select/suppliers")
	public List<Suppliers> getAllData(){
		return service.getAllData();
	}
	
	@GetMapping("/select/suppliersbyId/{id}")
	public Suppliers getById(@PathVariable("id") long id){
		return service.getById(id);
		
	}
	
	@PostMapping("/save/suppliers")
	public String insert(@RequestBody Suppliers s) {
		Suppliers d = service.getById(s.get_id());
		if(d == null) {
			service.saveData(s);
		    return "Supplier not exist";
		}
		else {
			return "Inserted Successfully";
		}
	}
	
	@PutMapping("/update/supplier")
	public String update(@RequestBody Suppliers s) {
		Suppliers d = service.getById(s.get_id());
		if(d == null) {
			service.update(s);
		    return "Supplier not exist";
		}
		else {
			return "Updated Successfully";
		}
	}
	
	@DeleteMapping("/delete/supplier/{id}")
	public String delete(@PathVariable("id") long id) {
		Suppliers d = service.getById(id);
		if(d == null) {
			service.delete(id);
		    return "Supplier not exist";
		}
		else {
			return "Deleted Successfully";
		}
	}
	
	@PutMapping("/update/supplier-name")
	public String updateName(@RequestParam String oldName , @RequestParam String newName) {
		service.updateSupplierName(oldName, newName);
		return "Updated Name Successfully";
	}
}
