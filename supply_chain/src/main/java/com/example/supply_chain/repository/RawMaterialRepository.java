package com.example.supply_chain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.supply_chain.model.RawMaterial;

public interface RawMaterialRepository extends MongoRepository<RawMaterial, Long>{

	List<RawMaterial> findBy_id(long _id);

	void deleteBy_id(long _id);

}
