package com.example.springmongodb.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document(collection="Test")
@Data
public class Test{

	@Id
	private String id;
	
	@Field("first_name")
	private String firstName;

	@Field("last_name")
	private String lastName;

	@Field("email")
	private String email;

	@Field("gender")
	private String gender;

	@Field("date")
	private Date date;
}
