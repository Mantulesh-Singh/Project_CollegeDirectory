package com.practice.CollegeDirectory.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.CollegeDirectory.model.FacultyProfile;
import com.practice.CollegeDirectory.model.StudentProfile;
import com.practice.CollegeDirectory.repository.FacultyProfileRepository;
import com.practice.CollegeDirectory.repository.StudentProfileRepository;

@Service
public class AdministratorService {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    // Add a new student
    public StudentProfile addStudent(StudentProfile studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }

    // Update a student's profile
    public StudentProfile updateStudent(Long studentId, StudentProfile updatedProfile) {
        StudentProfile existingProfile = studentProfileRepository.findById(studentId).orElse(null);
        if (existingProfile != null) {
            existingProfile.setDepartment(updatedProfile.getDepartment());
            existingProfile.setYear(updatedProfile.getYear());
            existingProfile.setPhoto(updatedProfile.getPhoto());
            return studentProfileRepository.save(existingProfile);
        }
        return null;
    }

    // Delete a student
    public void deleteStudent(Long studentId) {
        studentProfileRepository.deleteById(studentId);
    }

    // Add a new faculty member
    public FacultyProfile addFaculty(FacultyProfile facultyProfile) {
        return facultyProfileRepository.save(facultyProfile);
    }

    // Update a faculty member's profile
    public FacultyProfile updateFaculty(Long facultyId, FacultyProfile updatedProfile) {
        FacultyProfile existingProfile = facultyProfileRepository.findById(facultyId).orElse(null);
        if (existingProfile != null) {
            existingProfile.setOfficeHours(updatedProfile.getOfficeHours());
            existingProfile.setDepartment(updatedProfile.getDepartment());
            existingProfile.setPhoto(updatedProfile.getPhoto());
            return facultyProfileRepository.save(existingProfile);
        }
        return null;
    }

    // Delete a faculty member
    public void deleteFaculty(Long facultyId) {
        facultyProfileRepository.deleteById(facultyId);
    }

    // Get data for admin dashboard (e.g., statistics)
    public String getDashboardData() {
        // Implement logic for collecting and aggregating data
        return "Dashboard Data (e.g., student enrollment trends, faculty course loads)";
    }
}
