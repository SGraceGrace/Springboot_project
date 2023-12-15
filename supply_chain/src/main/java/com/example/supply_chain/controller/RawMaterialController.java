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
import org.springframework.web.bind.annotation.RestController;

import com.example.supply_chain.model.RawMaterial;
import com.example.supply_chain.service.RawMaterialServiceInterface;

@RestController
@RequestMapping("/rawmaterial")
public class RawMaterialController {

	@Autowired
	RawMaterialServiceInterface service;

	@GetMapping("/select/rawmaterial")
	public ResponseEntity<List<RawMaterial>> getAllData() {

		List<RawMaterial> list = service.getAllData();

		try {
			if (list != null) {
				ResponseEntity<List<RawMaterial>> response = new ResponseEntity<>(list, HttpStatus.OK);
				return response;
			} else {
				ResponseEntity<List<RawMaterial>> response = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
				return response;
			}
		} catch (Exception e) {
			ResponseEntity<List<RawMaterial>> response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	@GetMapping("/select/rawmaterialbyId/{id}")
	public ResponseEntity<RawMaterial> getById(@PathVariable("id") String id) {

		RawMaterial s = service.getById(id);

		try {
			if (s != null) {
				ResponseEntity<RawMaterial> response = new ResponseEntity<>(s, HttpStatus.OK);
				return response;
			} else {
				ResponseEntity<RawMaterial> response = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
				return response;
			}
		} catch (Exception e) {
			ResponseEntity<RawMaterial> response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	@PostMapping("/save/rawmaterial")
	public ResponseEntity<String> insert(@RequestBody RawMaterial r) {

		boolean check = service.existId(r.getMaterialUid());

		try {
			if (check == false) {
				service.saveData(r);
				ResponseEntity<String> response = new ResponseEntity<>("Inserted Successfully", HttpStatus.CREATED);
				return response;
			} else {
				ResponseEntity<String> response = new ResponseEntity<>("RawMaterial Already Exists",
						HttpStatus.FORBIDDEN);
				return response;
			}
		} catch (Exception e) {
			ResponseEntity<String> response = new ResponseEntity<>("Internal Server Error",
					HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	@PutMapping("/update/rawmaterial")
	public ResponseEntity<String> update(@RequestBody RawMaterial r) {

		boolean check = service.existId(r.getMaterialUid());

		try {
			if (check == true) {
				service.update(r);
				ResponseEntity<String> response = new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
				return response;
			} else {
				ResponseEntity<String> response = new ResponseEntity<>("RawMaterial Not Exists", HttpStatus.FORBIDDEN);
				return response;
			}
		} catch (Exception e) {
			ResponseEntity<String> response = new ResponseEntity<>("Internal Server Error",
					HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	@DeleteMapping("/delete/rawmaterial/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {

		boolean check = service.existId(id);

		try {
			if (check == true) {
				service.delete(id);
				ResponseEntity<String> response = new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
				return response;
			} else {
				ResponseEntity<String> response = new ResponseEntity<>("RawMaterial Not Exists", HttpStatus.FORBIDDEN);
				return response;
			}
		} catch (Exception e) {
			ResponseEntity<String> response = new ResponseEntity<>("Internal Server Error",
					HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}
}
