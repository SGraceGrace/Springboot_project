package com.project.elearning.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.elearning.model.Enrollment;

public interface EnrollmentRepository extends MongoRepository<Enrollment, String>{

	boolean existsByenrollmentUid();

	Enrollment findByenrollmentUid(String enrollmentUid);

	void deleteByenrollmentUid(String enrollmentUid);

}
