package com.example.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.model.Product;
import com.example.task.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping("/get")
	public List<Product> getProducts(){
		return service.getAllProducts();
	}
	
	@PreAuthorize("hasAuthority('WRITE')")
	@PostMapping("/add")
	public String addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	@PreAuthorize("hasAuthority('EDIT')")
	@PutMapping("/update")
	public String updateProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	@PreAuthorize("hasAuthority('DELETE')")
	@DeleteMapping("/delete")
	public String deleteProduct(String id) {
		return service.deleteProduct(id);
	}
}
