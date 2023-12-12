package com.example.supply_chain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.supply_chain.model.style;

public interface StyleRepository extends MongoRepository<style, Long>{

	List<style> findBy_id(long _id);

	void deleteBy_id(long id);


}
