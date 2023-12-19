package com.example.supply_chain.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.supply_chain.model.Photos;

public interface PhotoRepository extends MongoRepository<Photos, String> {

	Optional<Photos> findByphotoUid(String id);

	boolean existsByphotoUid(String photoUid);

	void deleteByPhotoUid(String photoUid);

	Photos findByPhotoUid(String photoUid);
	
}
