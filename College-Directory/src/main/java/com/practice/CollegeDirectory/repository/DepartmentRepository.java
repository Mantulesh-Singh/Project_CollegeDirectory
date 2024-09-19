package com.practice.CollegeDirectory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.CollegeDirectory.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Find a department by name
    Department findByName(String name);
}