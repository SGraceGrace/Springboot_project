package com.project.elearning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.elearning.model.Course;
import com.project.elearning.repository.CourseRepository;
import com.project.elearning.service.CourseService;

public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseRepository repository;

	@Override
	public void add(Course c) {
		repository.save(c);
	}

	@Override
	public boolean existsById(String courseUid) {
		return repository.existsBycourseUid(courseUid);
	}

	@Override
	public List<Course> getAllCourse() {
		return repository.findAll();
	}

	@Override
	public Course getById(String courseUid) {
		return repository.findByCourseUid();
	}

	@Override
	public void updateCourse(Course c) {
		repository.save(c);	
	}

	@Override
	public void deleteCourse(String courseUId) {
		repository.deleteByCourseUid(courseUId);
		
	}


}
