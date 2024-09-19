package com.practice.CollegeDirectory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.CollegeDirectory.model.StudentProfile;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
    
    // Custom query to find students by department and year
    List<StudentProfile> findByDepartmentIdAndYear(Long departmentId, String year);

    // Find students by name (or partial name)
    List<StudentProfile> findByNameContaining(String name);
}