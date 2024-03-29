package com.example.task.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	@Id
	private String id;
	
	@Field("role-name")
	private String roleName;
}
