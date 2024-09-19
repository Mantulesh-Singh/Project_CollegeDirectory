package com.practice.CollegeDirectory.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.CollegeDirectory.model.FacultyProfile;
import com.practice.CollegeDirectory.model.StudentProfile;
import com.practice.CollegeDirectory.repository.FacultyProfileRepository;
import com.practice.CollegeDirectory.repository.StudentProfileRepository;

@Service
public class FacultyService {

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    // Get the faculty profile by user ID
    public FacultyProfile getFacultyProfile(Long userId) {
        return facultyProfileRepository.findById(userId).orElse(null);
    }

    // Update the faculty profile
    public FacultyProfile updateFacultyProfile(Long userId, FacultyProfile updatedProfile) {
        FacultyProfile existingProfile = facultyProfileRepository.findById(userId).orElse(null);
        if (existingProfile != null) {
            existingProfile.setOfficeHours(updatedProfile.getOfficeHours());
            existingProfile.setPhoto(updatedProfile.getPhoto());
            existingProfile.setDepartment(updatedProfile.getDepartment());
            return facultyProfileRepository.save(existingProfile);
        }
        return null;
    }

    // Get the list of students in the faculty's class
    public List<StudentProfile> getStudentsByFacultyId(Long facultyId) {
        // Assuming we get students by the courses the faculty member is teaching
        // You'll need to join the `Enrollment` and `Course` tables to get the correct list.
        // For simplicity, let's assume the faculty profile directly links to students here.
        return studentProfileRepository.findAll();  // Adjust logic to fetch by course
    }
}
