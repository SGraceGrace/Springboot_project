package com.example.supply_chain.service;

import java.util.List;

import com.example.supply_chain.model.Facilities;

public interface FacilitiesServiceInterface {

	List<Facilities> getAllData();
	Facilities getById(String _id);
	void saveData(Facilities f);
	void update(Facilities f);
	void delete(String _id);
	void updateFacilityName(String oldName, String newName);
	boolean existId(String FacilitiesUid);
}
