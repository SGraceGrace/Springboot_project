package com.example.supply_chain.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supply_chain.dao.DaoInterface;
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
	
	public style getById(String _id){
//		List<style> list = repo.findBy_id(_id);
		Optional<style> result = repo.findById(_id);
		return result.get();
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
	
	public void deleteData(String _id) {
		repo.deleteBy_id(_id);
	}
	
	public List<style> getAllData(){
		return dao.getAllData();
		
	}

	@Override
	public void deletebyId(long id) {
		dao.deleteStyle(id);
	}
}

