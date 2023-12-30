package com.example.supply_chain.service;

import java.util.List;

import com.example.supply_chain.exception.StyleNotFound;
import com.example.supply_chain.model.style;

public interface StyleServiceInterface {

	List<style> getAllStyle();
	style getById(String _id) throws StyleNotFound;
	void addData(style s);
	void updateData(style s);
	void deleteData(String id);
	List<style> getAllData();
	void deletebyId(String id);
	boolean existId(String styleUid);
}
