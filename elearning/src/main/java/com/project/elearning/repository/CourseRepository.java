package com.project.elearning.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.elearning.model.Course;

public interface CourseRepository extends MongoRepository<Course, String>{

	boolean existsBycourseUid(String courseUid);

	Course findByCourseUid();

	void deleteByCourseUid(String courseUId);

}
