package com.fullstack.newsplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.newsplatform.model.TransactionDetails;
import com.fullstack.newsplatform.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService service;

	@GetMapping("/createTransaction")
	public TransactionDetails createTransaction(@RequestParam Double amount) {
		return service.createTransaction(amount);
	}
}
