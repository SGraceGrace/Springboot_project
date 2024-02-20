package com.example.task.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.task.model.Product;


public interface ProductRepository extends MongoRepository<Product, String>{

}
