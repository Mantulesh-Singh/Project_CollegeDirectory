package com.practice.CollegeDirectory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.CollegeDirectory.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // Find courses by department
    List<Course> findByDepartmentId(Long departmentId);

    // Find courses by faculty (who teaches the course)
    List<Course> findByFacultyId(Long facultyId);
}