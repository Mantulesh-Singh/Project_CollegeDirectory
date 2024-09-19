package com.practice.CollegeDirectory.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.CollegeDirectory.model.FacultyProfile;
import com.practice.CollegeDirectory.model.StudentProfile;
import com.practice.CollegeDirectory.repository.FacultyProfileRepository;
import com.practice.CollegeDirectory.repository.StudentProfileRepository;

@Service
public class StudentService {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    // Get the profile of a student by user ID
    public StudentProfile getStudentProfile(Long userId) {
        return studentProfileRepository.findById(userId).orElse(null);
    }

    // Search for students based on name, department, and year
    public List<StudentProfile> searchStudents(String name, String department, String year) {
        // Implementing search logic based on available fields
        if (department != null && year != null) {
            return studentProfileRepository.findByDepartmentIdAndYear(Long.parseLong(department), year);
        } else if (name != null) {
            return studentProfileRepository.findByNameContaining(name);
        }
        return null;
    }

    // Get the list of faculty advisors for a student
    public List<FacultyProfile> getFacultyAdvisorsForStudent(Long studentId) {
        // Assuming faculty advisors are determined by department
        StudentProfile studentProfile = studentProfileRepository.findById(studentId).orElse(null);
        if (studentProfile != null) {
            return facultyProfileRepository.findByDepartmentId(studentProfile.getDepartment().getId());
        }
        return null;
    }
}
