package com.example.supply_chain.service;

import java.util.List;

import com.example.supply_chain.model.RawMaterial;

public interface RawMaterialServiceInterface {

	List<RawMaterial> getAllData();
	List<RawMaterial> getById(long _id);
	void saveData(RawMaterial r);
	void update(RawMaterial r);
	void delete(long _id);
}
