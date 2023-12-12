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

import com.example.supply_chain.model.Facilities;
import com.example.supply_chain.model.RawMaterial;
import com.example.supply_chain.service.RawMaterialServiceInterface;

@RestController
@RequestMapping("/rawmaterial")
public class RawMaterialController {

	@Autowired
	RawMaterialServiceInterface service;
	
	@GetMapping("/select/rawmaterial")
	public List<RawMaterial> getAllData(){
		return service.getAllData();
	}
	
	@GetMapping("/select/rawmaterialbyId/{id}")
	public RawMaterial getById(@PathVariable("id") long id){
		return service.getById(id);
		
	}
	
	@PostMapping("/save/rawmaterial")
	public String insert(@RequestBody RawMaterial r) {
		RawMaterial d = service.getById(r.get_id());
		if(d == null) {
			service.saveData(r);
		    return "RawMaterial not exist";
		}
		else {
			return "Inserted Successfully";
		}
	}
	
	@PutMapping("/update/rawmaterial")
	public String update(@RequestBody RawMaterial r) {
		RawMaterial d = service.getById(r.get_id());
		if(d == null) {
			service.update(r);
		    return "RawMaterial not exist";
		}
		else {
			return "Updated Successfully";
		}
	}
	
	@DeleteMapping("/delete/rawmaterial/{id}")
	public String delete(@PathVariable("id") long id) {
		RawMaterial d = service.getById(id);
		if(d == null) {
			service.delete(id);
		    return "RawMaterial not exist";
		}
		else {
			return "Deleted Successfully";
		}
	}
}
