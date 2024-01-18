package com.project.elearning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.elearning.model.Enrollment;
import com.project.elearning.repository.EnrollmentRepository;
import com.project.elearning.service.EnrollmentService;

public class EnrollmentSeviceImpl implements EnrollmentService{
	
	@Autowired
	EnrollmentRepository repository;

	@Override
	public void add(Enrollment e) {
		repository.save(e);
	}

	@Override
	public boolean existsById(String enrollmentUid) {
		return repository.existsByenrollmentUid();
	}

	@Override
	public List<Enrollment> getAllEnrollments() {
		return repository.findAll();
	}

	@Override
	public Enrollment getById(String enrollmentUid) {
		return repository.findByenrollmentUid(enrollmentUid);
	}

	@Override
	public void updateEnrollment(Enrollment e) {
		repository.save(e);
		
	}

	@Override
	public void deleteEnrollment(String enrollmentUid) {
		repository.deleteByenrollmentUid(enrollmentUid);
		
	}

}
