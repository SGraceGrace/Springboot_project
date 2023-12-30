package com.example.supply_chain.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supply_chain.dao.DaoInterface;
import com.example.supply_chain.exception.StyleNotFound;
import com.example.supply_chain.model.style;
import com.example.supply_chain.repository.StyleRepository;
import com.example.supply_chain.service.StyleServiceInterface;

@Service
public class StyleService implements StyleServiceInterface{
	
	@Autowired
	StyleRepository repo;
	
	@Autowired
	DaoInterface dao;;

	public List<style> getAllStyle(){		
		List<style> list = new ArrayList<>();
		list = repo.findAll();
		return list;		
	}
	
	public style getById(String id) throws StyleNotFound{
		Optional<style> result = repo.findBystyleUid(id);
		if(result.isPresent())
		return result.get();
		else
			throw new StyleNotFound(null);
	}
	
	public void addData(style s) {
//		boolean check = dao.checkStyle(s.get_id());
//		
//		if(check == false) {
		repo.save(s);
//		return true;
//		}else {
//			return false;
//		}
	}
	
	public boolean existId(String styleUid) {		
		return repo.existsBystyleUid(styleUid);
	}
	
	public void updateData(style s) {
		dao.updateStyle(s);
	}
	
	public void deleteData(String id) {
		repo.deleteBystyleUid(id);
	}
	
	public List<style> getAllData(){
		return dao.getAllData();
		
	}

	@Override
	public void deletebyId(String id) {
		dao.deleteStyle(id);
	}
	 
}

