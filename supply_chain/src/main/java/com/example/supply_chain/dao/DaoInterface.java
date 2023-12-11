package com.example.supply_chain.dao;

import java.util.List;

import com.example.supply_chain.model.style;

public interface DaoInterface {

	List<style> getAllData();
	void supplierNameUpdate(String oldName,String newName);
	void supplierNameUpdateInstyle(String oldName , String newName);
	void facilityNameUpdate(String oldName, String newName);
	void facilityNameUpdateInstyle(String oldName, String newName);
}
