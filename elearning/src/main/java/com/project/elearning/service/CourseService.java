package com.project.elearning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.elearning.model.Course;

@Service
public interface CourseService {

	void add(Course c);
	boolean existsById(String courseUid);
	List<Course> getAllCourse();
	Course getById(String courseUid);
	void updateCourse(Course c);
	void deleteCourse(String courseUId);
}
