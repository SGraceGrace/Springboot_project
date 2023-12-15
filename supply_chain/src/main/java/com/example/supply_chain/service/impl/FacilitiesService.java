package com.example.supply_chain.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supply_chain.dao.DaoInterface;
import com.example.supply_chain.model.Facilities;
import com.example.supply_chain.repository.FacilitiesRepository;
import com.example.supply_chain.service.FacilitiesServiceInterface;

@Service
public class FacilitiesService implements FacilitiesServiceInterface {

	@Autowired
	FacilitiesRepository repo;

	@Autowired
	DaoInterface dao;

	public List<Facilities> getAllData() {
		List<Facilities> list = new ArrayList<>();
		list = repo.findAll();
		return list;
	}

	public boolean existId(String FacilitiesUid) {
		return repo.existsByFacilitiesUid(FacilitiesUid);
	}

	public Facilities getById(String _id) {
		Optional<Facilities> list = repo.findById(_id);
		return list.get();
	}

	public void saveData(Facilities f) {
		repo.save(f);
	}

	public void update(Facilities f) {
		dao.updatefacility(f);
	}

	public void delete(String _id) {
		repo.deleteBy_id(_id);
	}

	public void updateFacilityName(String oldName, String newName) {
		dao.facilityNameUpdate(oldName, newName);
	}
}
