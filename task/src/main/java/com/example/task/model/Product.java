package com.example.task.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Data;

@Document(collection = "product")
@Data
@Builder
public class Product {
	
	@Id
	private String id;
	
	@Field("product-name")
	private String productName;
	
	@Field("quantity")
	private String quantity;
}
