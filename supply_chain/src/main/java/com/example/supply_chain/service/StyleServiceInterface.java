package com.example.supply_chain.service;

import java.util.List;

import com.example.supply_chain.model.Style;

public interface StyleServiceInterface {

	List<Style> getAllStyle();
	List<Style> getById(long _id);
	void addData(Style s);
	void updateData(Style s);
	void deleteData(long _id);
	List<Style> getAllData();
}
