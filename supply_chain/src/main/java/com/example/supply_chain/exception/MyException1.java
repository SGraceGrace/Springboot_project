package com.example.supply_chain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyException1 {

	@ExceptionHandler(value=StyleNotFound.class)
	public ResponseEntity<Object> StylenotExistexception(StyleNotFound s_exp){
		
		return new ResponseEntity<>("Style Not Found" , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=SupplierNotFound.class)
	public ResponseEntity<Object> SuppliernotExistexception(SupplierNotFound s_exp){
		
		return new ResponseEntity<>("Supplier Not Found" , HttpStatus.NOT_FOUND);
	}
}
