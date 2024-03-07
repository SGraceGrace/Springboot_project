package com.fullstack.newsplatform.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.fullstack.newsplatform.model.News;

public interface NewsRepository extends MongoRepository<News, String>{

	@Query(sort = "{'date':-1}")
	Page<News> findAllByStatus(String string, Pageable pageable);

	@Query(value = "{'status': 'ACCEPTED'}")
	List<News> findAllByDate(Date date);

	@Query(sort = "{'date':-1}")
	List<News> findAllByCategory(String string);

	List<News> findAllByViews();

	@Query(sort = "{'date':-1}")
	List<News> findAllByStatus(String string);

}
