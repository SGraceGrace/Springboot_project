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

import com.example.supply_chain.model.Style;
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
	public List<Style> select() {		
		return service.getAllStyle();		
	}
	
	@GetMapping("/select/stylebyId/{id}")
	public List<Style> selectById(@PathVariable("id") long id){
		return service.getById(id);
		
	}
	
	@PostMapping("/add/style")
	public String insert(@RequestBody Style s) {
		service.addData(s);
		return "Inserted Successfully";
		
	}
	
	@PutMapping("/update/style")
	public String update(@RequestBody Style s) {
		service.updateData(s);
		return "Updated Successfully";
	}
	
	@DeleteMapping("/delete/style/{id}")
	public String deleteById(@PathVariable("id") long id) {
		service.deleteData(id);
		return "deleted Successfully";
	}
	
	@GetMapping("/select/style/dao")
	public List<Style> getData(){
		return service.getAllData();
	}1															11		1qq	1	1q1	q1	q			11	q																																	q11111
}
