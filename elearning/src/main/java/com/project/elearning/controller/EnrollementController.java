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

import com.project.elearning.model.Enrollment;
import com.project.elearning.service.EnrollmentService;

@RestController
@RequestMapping("enrollment")
public class EnrollementController {
	
	@Autowired
	EnrollmentService service;

	@PostMapping("add-enrollment")
	public ResponseEntity<String> saveEnrollment(@RequestBody Enrollment enroll) {

		try {
			boolean check = service.existsById(enroll.getEnrollmentUid());

			if (check) {
				return new ResponseEntity<>("Already Exists", HttpStatus.FORBIDDEN);
			} else {
				service.add(enroll);
				return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("all-users")
	public ResponseEntity<List<Enrollment>> getAllEnrollment() {
		try {
			List<Enrollment> enrollments = service.getAllEnrollments();
			if (enrollments != null) {
				return new ResponseEntity<>(enrollments, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("user/{userUid}")
	public ResponseEntity<Enrollment> getById(@PathVariable String enrollmentUId) {
		try {
			Enrollment enrollment = service.getById(enrollmentUId);
			if (enrollment != null) {
				return new ResponseEntity<>(enrollment, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("update-user")
	public ResponseEntity<String> updateEnrollment(@RequestBody Enrollment enroll){
		try {
			boolean check = service.existsById(enroll.getEnrollmentUid());

			if (check) {
				service.updateEnrollment(enroll);
				return new ResponseEntity<>("Updated Successfully", HttpStatus.FORBIDDEN);
			} else {
				return new ResponseEntity<>("Enrollment Not Exists", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("delete-user")
	public ResponseEntity<String> deleteEnrollment(@PathVariable String enrollmentUId){
		try {
			boolean check = service.existsById(enrollmentUId);

			if (check) {
				service.deleteEnrollment(enrollmentUId);
				return new ResponseEntity<>("Deleted Successfully", HttpStatus.FORBIDDEN);
			} else {
				return new ResponseEntity<>("Enrollment Not Exists", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
