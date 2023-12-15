package com.example.supply_chain.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.supply_chain.dao.DaoInterface;
import com.example.supply_chain.model.Facilities;
import com.example.supply_chain.model.RawMaterial;
import com.example.supply_chain.model.Suppliers;
import com.example.supply_chain.model.style;

@Repository
public class DaoImplementation implements DaoInterface {

	MongoTemplate template;

	public DaoImplementation(MongoTemplate template) {
		this.template = template;
	}

	public List<style> getAllData() {
		return template.findAll(style.class);
	}

	public void supplierNameUpdate(String oldName, String newName) {

		Criteria criteria = Criteria.where("supplier_name").is(oldName);
		Query query = new Query(criteria);

		Update update = new Update().set("supplier_name", newName);

		template.updateFirst(query, update, Suppliers.class);

		supplierNameUpdateInstyle(oldName, newName);
	}

	public void supplierNameUpdateInstyle(String oldName, String newName) {

		Criteria criteria = Criteria.where("supplier_name").is(oldName);
		Query query = new Query(criteria);

		Update update = new Update().set("supplier_name", newName);

		template.updateFirst(query, update, style.class);
	}

	public void facilityNameUpdate(String oldName, String newName) {

		Criteria criteria = Criteria.where("facility_name").is(oldName);
		Query query = new Query(criteria);

		Update update = new Update().set("facility_name", newName);

		template.updateFirst(query, update, Facilities.class);

		facilityNameUpdateInstyle(oldName, newName);
	}

	public void facilityNameUpdateInstyle(String oldName, String newName) {

		Criteria criteria = Criteria.where("facility_name").is(oldName);
		Query query = new Query(criteria);

		Update update = new Update().set("facility_name", newName);

		template.updateFirst(query, update, style.class);
	}
	
	public void deleteStyle(long id) {
		
		Criteria criteria = Criteria.where("_id").is(id);
	    Query query = new Query(criteria);
		template.remove(query, style.class);
	}

	public void updatefacility(Facilities f) {		
		Criteria criteria = Criteria.where("facilities_uid").is(f.getFacilitiesUid());
		Query query = new Query(criteria);
		template.replace(query, f);
		
	}

	public void updateSuppliers(Suppliers s) {
		Criteria criteria = Criteria.where("supplier_uid").is(s.getSupplierUid());
		Query query = new Query(criteria);
		template.replace(query, s);
	}

	public void updateStyle(style s) {
		Criteria criteria = Criteria.where("style_uid").is(s.getStyleUid());
		Query query = new Query(criteria);
		template.replace(query, s);
	}

	public void updateRawMaterial(RawMaterial r) {
		Criteria criteria = Criteria.where("material_uid").is(r.getMaterialUid());
		Query query = new Query(criteria);
		template.replace(query, r);
	}
	
//	public boolean checkStyle(long id) {
//		
//		Criteria criteria = Criteria.where("_id").is(id);
//	    Query query = new Query(criteria);
//	    
//	    //List<style> list = new ArrayList<>();
//	    
//		//list=template.find(query, style.class);
//		
//		long count = template.count(query, style.class);
//		//System.out.println(count);
//		if(count > 0) {
//			return true;
//		}
//		return false;
//	}
}
