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

import com.example.supply_chain.model.Facilities;
import com.example.supply_chain.service.FacilitiesServiceInterface;

@RestController
@RequestMapping("/facilities")
public class FacilitiesController {

	@Autowired
	FacilitiesServiceInterface service;

	@GetMapping("/select/facilities")
	public ResponseEntity<List<Facilities>> getAllFacilities() {

		List<Facilities> list = service.getAllData();
		try {
			if (list != null) {
				ResponseEntity<List<Facilities>> response = new ResponseEntity<>(list, HttpStatus.OK);
				return response;
			} else {
				ResponseEntity<List<Facilities>> response = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
				return response;
			}
		} catch (Exception e) {
			ResponseEntity<List<Facilities>> response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	@GetMapping("/select/facilitiesbyId/{id}")
	public ResponseEntity<Facilities> getById(@PathVariable("id") String id) {

		Facilities f = service.getById(id);

		try {
			if (f != null) {
				ResponseEntity<Facilities> response = new ResponseEntity<>(f, HttpStatus.OK);
				return response;
			} else {
				ResponseEntity<Facilities> response = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
				return response;
			}
		} catch (Exception e) {
			ResponseEntity<Facilities> response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	@PostMapping("/save/facilities")
	public ResponseEntity<String> insert(@RequestBody Facilities f) {

		boolean check = service.existId(f.getFacilitiesUid());

		try {
			if (check == false) {
				service.saveData(f);
				ResponseEntity<String> response = new ResponseEntity<>("Inserted Successfully", HttpStatus.CREATED);
				return response;
			} else {
				ResponseEntity<String> response = new ResponseEntity<>("Facility Already Exists", HttpStatus.FORBIDDEN);
				return response;
			}
		} catch (Exception e) {
			ResponseEntity<String> response = new ResponseEntity<>("Internal Server Error",
					HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	@PutMapping("/update/facility")
	public ResponseEntity<String> update(@RequestBody Facilities f) {

		boolean check = service.existId(f.getFacilitiesUid());

		try {
			if (check == true) {
				service.update(f);
				ResponseEntity<String> response = new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
				return response;
			} else {
				ResponseEntity<String> response = new ResponseEntity<>("Facility Not Exists", HttpStatus.FORBIDDEN);
				return response;
			}
		} catch (Exception e) {
			ResponseEntity<String> response = new ResponseEntity<>("Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	@DeleteMapping("/delete/facility/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {

		boolean check = service.existId(id);

		try {
			if (check == true) {
				service.delete(id);
				ResponseEntity<String> response = new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
				return response;
			} else {
				ResponseEntity<String> response = new ResponseEntity<>("Facility Not Exists", HttpStatus.FORBIDDEN);
				return response;
			}
		} catch (Exception e) {
			ResponseEntity<String> response = new ResponseEntity<>("Internal Server Error",
					HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	@PutMapping("/update/facility-name")
	public String updateName(@RequestParam String oldName, @RequestParam String newName) {
		service.updateFacilityName(oldName, newName);
		return "Updated Successfully";
	}
}
