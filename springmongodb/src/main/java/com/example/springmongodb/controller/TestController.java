package com.example.springmongodb.controller;


import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.example.springmongodb.model.Test;
import com.example.springmongodb.repo.TestRepository;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:8089")
public class TestController {

	@Autowired
	TestRepository test;
	
	@GetMapping("/alldata")
	public String display() {		
		return "display";		
	}
	
	@GetMapping("/data")
	public List<Test> select() {
		return test.findAll();		
	}
	
	@GetMapping("/count")
	public long count() {
		return test.count();
	}
	
	@GetMapping("/data/{id}")
	public Test getTest(@PathVariable String id) {
		return test.findById(id).get();
	}
	
	@GetMapping("/databyname")
	public Test getTestByName(@RequestParam String name) {
		return test.findByFirstName(name);
	}
	
	@GetMapping("/byDate/{from}/{to}")
	public List<Test> selectByDate(@PathVariable String from, @PathVariable String to) throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");
		Date fromDate = dateFormat.parse(from);
		Date toDate = dateFormat.parse(to);
		Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
//		return test.findAllByDateBetweenOrderByFirstNameAsc(fromDate, toDate);
		return test.findAllByDateBetween(fromDate, toDate, sort);
	}
	
	@GetMapping("/contains")
	public List<Test> getAllTests() {
		return test.findByRegex("@shareasale.com");
	}
	
	@GetMapping("/countbygender/{gender}")
	public long countByGender(@PathVariable String gender) {
		return test.countByGender(gender);
	}
	
//	@GetMapping("/getbyname")
//	public List<Test> getByName() {
//		return test.findAllBy
//	}
	
}
