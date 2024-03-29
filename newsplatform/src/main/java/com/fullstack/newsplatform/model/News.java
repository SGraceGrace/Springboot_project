package com.fullstack.newsplatform.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Data;

@Document(collection = "news")
@Data
@Builder
public class News {

	@Id
	private String id;
	
	@Field("newsUid")
	private String newsUid;
	
	@Field("title")
	private String title;
	
	@Field("synopsis")
	private String synopsis;
	
	@Field("images")
	private List<String> images;
	
	@Field("content")
	private String content;
	
	@Field("category")
	private String category;
	
	@Field("date")
	private LocalDate date;
	
	@Field("views")
	private int views;
	
	@Field("reason")
	private String reason;
	
	@Field("status")
	private String status;
}
