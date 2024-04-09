package com.example.springmongodb.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.springmongodb.model.Test;

public interface TestRepository extends MongoRepository<Test,String>{

	List<Test> findAllByDateBetween(Date from, Date to);

	List<Test> findAllByDateBetweenOrderByFirstNameAsc(Date fromDate, Date toDate);

	List<Test> findAllByDateBetween(Date fromDate, Date toDate, Sort sort);

	Test findByFirstName(String name);

	@Query("{email : {$regex : ?0}}")
	List<Test> findByRegex(String string);

	long countByGender(String gender);
}
