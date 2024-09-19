package com.practice.CollegeDirectory.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.CollegeDirectory.Service.FacultyService;
import com.practice.CollegeDirectory.Service.StudentService;
import com.practice.CollegeDirectory.model.FacultyProfile;
import com.practice.CollegeDirectory.model.StudentProfile;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private StudentService studentService;

    // View class list
    @GetMapping("/{id}/class-list")
    public List<StudentProfile> getClassList(@PathVariable Long id) {
        return (List<StudentProfile>) studentService.getStudentProfile(id);
    }

    // Update faculty profile
    @PutMapping("/{id}/profile")
    public FacultyProfile updateProfile(@PathVariable Long id,
                                        @RequestBody FacultyProfile updatedProfile) {
        return facultyService.updateFacultyProfile(id, updatedProfile);
    }
}