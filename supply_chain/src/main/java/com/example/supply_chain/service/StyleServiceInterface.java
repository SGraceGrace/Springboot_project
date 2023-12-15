package com.example.supply_chain.service;

import java.util.List;

import com.example.supply_chain.model.style;

public interface StyleServiceInterface {

	List<style> getAllStyle();
	style getById(String _id);
	void addData(style s);
	void updateData(style s);
	void deleteData(String id);
	List<style> getAllData();
	void deletebyId(long id);
	boolean existId(String styleUid);
}
