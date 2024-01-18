package com.project.elearning.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubModules {

	@Field("submodule_id")
	private String subModuleId;
	
	@Field("title")
	private String title;
	
	@Field("content")
	private String content;
	
	@Field("duration")
	private int duration;
}
