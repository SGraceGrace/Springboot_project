package com.example.supply_chain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.supply_chain.model.Facilities;

public interface FacilitiesRepository extends MongoRepository<Facilities,String>{

	List<Facilities> findBy_id(long _id);

	void deleteBy_id(String _id);

	boolean existsByFacilitiesUid(String facilitiesUid);

	Optional<Facilities> findByFacilitiesUid(String id);

	void deleteByFacilitiesUid(String id);

}
