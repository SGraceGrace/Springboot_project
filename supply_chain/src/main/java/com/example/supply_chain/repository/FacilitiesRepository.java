package com.example.supply_chain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.supply_chain.model.Facilities;

public interface FacilitiesRepository extends MongoRepository<Facilities,Long>{

	List<Facilities> findBy_id(long _id);

	void deleteBy_id(long _id);

}
