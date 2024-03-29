	package com.fullstack.newsplatform.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Data;

@Document(collection = "shortReads")
@Data
@Builder
public class ShortReads {

	@Id
	private String id;
	
	@Field("shortReadsUid")
	private String shortReadsUid;
	
	@Field("title")
	private String title;
	
	@Field("image")
	private String image;
	
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
