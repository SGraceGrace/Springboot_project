package com.example.task.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "permission")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Permission {
	
	@Id
	private String id;
	
	@Field("rolePermission-name")
	private String rolePermissionName;
}