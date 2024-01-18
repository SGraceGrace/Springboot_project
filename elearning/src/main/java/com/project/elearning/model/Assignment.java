package com.project.elearning.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {

	@Id
	private String id;
	
	@Field("title")
	private String title;
	
	@Field("questions")
	private ArrayList<Questions> questions;
	
	@Field("duration")
	private int duration;
}
