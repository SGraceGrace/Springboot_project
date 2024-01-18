package com.project.elearning.model;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modules {
	
	@Field("module_id")
	private String moduleId;
	
	@Field("title")
	private String title;
	
	@Field("duration")
	private int duration;
	
	@Field("level")
	private String level;
	
	@Field("sub_modules")
	private ArrayList<SubModules> subModules;
	
}
