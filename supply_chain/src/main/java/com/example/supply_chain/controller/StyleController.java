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
import org.springframework.web.bind.annotation.RestController;

import com.example.supply_chain.model.style;
import com.example.supply_chain.service.StyleServiceInterface;


@RestController
@RequestMapping("/style")
public class StyleController {

	@Autowired
	StyleServiceInterface service;
	
	@GetMapping("/test")
	public String display() {		
		return "hihello";		
	}
	
	@GetMapping("/select-style")
	public List<style> select() {		
		return service.getAllStyle();		
	}
	
	@GetMapping("/select/stylebyId/{id}")
	public style selectById(@PathVariable("id") long id){
		return service.getById(id);
		
	}
	
	@PostMapping("/add/style")
	public String insert(@RequestBody style s) {
		style d = service.getById(s.get_id());
		//boolean check = service.addData(s);
		
		if(d == null) {
			service.addData(s);
		    return "Style not exist";
		}
		else {
			return "Style already exist";
		}
//		boolean check = service.addData(s);
//		
//		if(check == true)
//		    return "Inserted Successfully";
//		
//		else
//			return "Style already exist";		
	}
	
	@PutMapping("/update/style")
	public String update(@RequestBody style s) {
		style d = service.getById(s.get_id());
		if(d == null) {
			service.updateData(s);
		    return "Style not exist";
		}
		else {
			return "Updated Successfully";
		}
	}
	
	@DeleteMapping("/delete/style/{id}")
	public String deleteById(@PathVariable("id") long id) {
		style d = service.getById(id);
		if(d == null) {
			service.deleteData(id);
		    return "Style not exist";
		}
		else {
			return "Deleted Successfully";
		}	
	}
	
	@GetMapping("/select/style/dao")
	public List<style> getData(){
		return service.getAllData();
	}		
	
	@DeleteMapping("/delete/stylebyId/{id}")
	public String deleteId(@PathVariable ("id") long id) {
		style d = service.getById(id);
		if(d == null) {
			service.deleteData(id);
		    return "Style not exist";
		}
		else {
			return "Deleted Successfully";
		}
	}
}
