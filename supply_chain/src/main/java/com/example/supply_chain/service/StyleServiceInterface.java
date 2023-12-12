package com.example.supply_chain.service;

import java.util.List;

import com.example.supply_chain.model.style;

public interface StyleServiceInterface {

	List<style> getAllStyle();
	List<style> getById(long _id);
	boolean addData(style s);
	void updateData(style s);
	void deleteData(long _id);
	List<style> getAllData();
	void deletebyId(long id);
}
