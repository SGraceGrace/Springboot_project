package com.example.supply_chain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.supply_chain.model.style;

public interface StyleRepository extends MongoRepository<style, String>{

	List<style> findBy_id(long _id);

	void deleteBy_id(String _id);

	boolean existsBystyleUid(String styleUid);

	void deleteBystyleUid(String id);

	Optional<style> findBystyleUid(String id);


}
