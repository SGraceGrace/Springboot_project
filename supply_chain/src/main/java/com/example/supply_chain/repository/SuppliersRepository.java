package com.example.supply_chain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.supply_chain.model.Suppliers;

public interface SuppliersRepository extends MongoRepository<Suppliers,String>{

	void deleteBy_id(long _id);

	List<Suppliers> findBy_id(long _id);

}
