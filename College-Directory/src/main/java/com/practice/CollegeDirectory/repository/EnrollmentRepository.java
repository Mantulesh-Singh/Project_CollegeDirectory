package com.practice.CollegeDirectory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.CollegeDirectory.model.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    // Find all enrollments by student ID
    List<Enrollment> findByStudentId(Long studentId);

    // Find all students enrolled in a particular course
    List<Enrollment> findByCourseId(Long courseId);
}
