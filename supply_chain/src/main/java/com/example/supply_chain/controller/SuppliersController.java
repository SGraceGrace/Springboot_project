package com.example.supply_chain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Suppliers>> getAllData(){
		
		List<Suppliers> list = service.getAllData();
		
		try {
			if(list != null) {
		        ResponseEntity<List<Suppliers>> response = new ResponseEntity<>(list,HttpStatus.OK);
		        return response;
			}else {
				ResponseEntity<List<Suppliers>> response = new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
				return response;
			}
		}
		catch(Exception e) {
			ResponseEntity<List<Suppliers>> response = new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
			
	}
	
	@GetMapping("/select/suppliersbyId/{id}")
	public ResponseEntity<Suppliers> getById(@PathVariable("id") String supplierUid){
		
		Suppliers s = service.getById(supplierUid);
		
		try {
			if(s != null) {
				ResponseEntity<Suppliers> response = new ResponseEntity<>(s,HttpStatus.OK);
		        return response;
			}else {
				ResponseEntity<Suppliers> response = new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
				return response;
			}
		}catch(Exception e){
			ResponseEntity<Suppliers> response = new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}
	
	@PostMapping("/save/suppliers")
	public ResponseEntity<String> insert(@RequestBody Suppliers s) {
		
		boolean check = service.existId(s.getSupplierUid());
		
		try {
		    if(check == false) {
		    	service.saveData(s);
		    	ResponseEntity<String> response = new ResponseEntity<>("Inserted Successfully",HttpStatus.CREATED);
		        return response;
		    }else {
		    	ResponseEntity<String> response = new ResponseEntity<>("Supplier Already Exists",HttpStatus.FORBIDDEN);
		        return response;
		}
		}catch(Exception e) {
			ResponseEntity<String> response = new ResponseEntity<>("Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}
	
	@PutMapping("/update/supplier")
	public ResponseEntity<String> update(@RequestBody Suppliers s) {
		
		boolean check = service.existId(s.getSupplierUid());
		
		try {
		if(check == true) {
			service.update(s);
			ResponseEntity<String> response = new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
	        return response;
		}
		else {
			ResponseEntity<String> response = new ResponseEntity<>("Supplier Not Exists",HttpStatus.FORBIDDEN);
	        return response;
		}
		}catch(Exception e) {
			ResponseEntity<String> response = new ResponseEntity<>("Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}
	
	@DeleteMapping("/delete/supplier/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		
		boolean check = service.existId(id);
		
		try {
			if(check == true) {
				service.delete(id);
				ResponseEntity<String> response = new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
		        return response;
			}
			else {
				ResponseEntity<String> response = new ResponseEntity<>("Supplier Not Exists",HttpStatus.FORBIDDEN);
		        return response;
			}
			}catch(Exception e) {
				ResponseEntity<String> response = new ResponseEntity<>("Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
				return response;
			}
	}
	
	@PutMapping("/update/supplier-name")
	public String updateName(@RequestParam String oldName , @RequestParam String newName) {
		service.updateSupplierName(oldName, newName);
		return "Updated Name Successfully";
	}
}
