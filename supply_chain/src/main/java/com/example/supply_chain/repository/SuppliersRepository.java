package com.example.supply_chain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.supply_chain.model.Suppliers;

public interface SuppliersRepository extends MongoRepository<Suppliers,String>{

	void deleteBy_id(String _id);

	List<Suppliers> findBy_id(String _id);
	
	Optional<Suppliers> findBySupplierUid(String supplierUid);

	boolean existsBySupplierUid(String supplierUid);
}
