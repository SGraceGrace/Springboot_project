package com.project.elearning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.elearning.model.Enrollment;

@Service
public interface EnrollmentService {

	void add(Enrollment e);
	boolean existsById(String enrollmentUid);
	List<Enrollment> getAllEnrollments();
	Enrollment getById(String enrollmentUid);
	void updateEnrollment(Enrollment e);
	void deleteEnrollment(String enrollmentUid);
}
