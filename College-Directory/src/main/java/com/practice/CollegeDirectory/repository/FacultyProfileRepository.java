package com.practice.CollegeDirectory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.CollegeDirectory.model.FacultyProfile;

@Repository
public interface FacultyProfileRepository extends JpaRepository<FacultyProfile, Long> {
    
    // Find faculty by department
    List<FacultyProfile> findByDepartmentId(Long departmentId);

    // Additional queries like finding by name or office hours can be added here
}