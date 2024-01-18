package com.project.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.elearning.model.Course;
import com.project.elearning.service.CourseService;

@RestController
@RequestMapping("course")
public class CourseController {

	@Autowired
	CourseService service;

	@PostMapping("add-course")
	public ResponseEntity<String> saveCourse(@RequestBody Course c) {

		try {
			boolean check = service.existsById(c.getCourseUid());

			if (check) {
				return new ResponseEntity<>("Already Exists", HttpStatus.FORBIDDEN);
			} else {
				service.add(c);
				return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("all-course")
	public ResponseEntity<List<Course>> getAllCourse() {
		try {
			List<Course> courses = service.getAllCourse();
			if (courses != null) {
				return new ResponseEntity<>(courses, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("course/{courseUid}")
	public ResponseEntity<Course> getById(@PathVariable String courseUId) {
		try {
			Course course = service.getById(courseUId);
			if (course != null) {
				return new ResponseEntity<>(course, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("update-course")
	public ResponseEntity<String> updateCourse(@RequestBody Course c){
		try {
			boolean check = service.existsById(c.getCourseUid());

			if (check) {
				service.updateCourse(c);
				return new ResponseEntity<>("Updated Successfully", HttpStatus.FORBIDDEN);
			} else {
				return new ResponseEntity<>("Course Not Exists", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("delete-course")
	public ResponseEntity<String> deleteCourse(@PathVariable String courseUId){
		try {
			boolean check = service.existsById(courseUId);

			if (check) {
				service.deleteCourse(courseUId);
				return new ResponseEntity<>("Deleted Successfully", HttpStatus.FORBIDDEN);
			} else {
				return new ResponseEntity<>("Course Not Exists", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
