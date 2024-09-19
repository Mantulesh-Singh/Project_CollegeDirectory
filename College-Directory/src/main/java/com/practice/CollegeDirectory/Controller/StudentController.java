package com.practice.CollegeDirectory.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.CollegeDirectory.Service.FacultyService;
import com.practice.CollegeDirectory.Service.StudentService;
import com.practice.CollegeDirectory.model.FacultyProfile;
import com.practice.CollegeDirectory.model.StudentProfile;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    // View personal profile
    @GetMapping("/{id}/profile")
    public StudentProfile viewProfile(@PathVariable Long id) {
        return studentService.getStudentProfile(id);
    }

    // Search for other students
    @GetMapping("/search")
    public List<StudentProfile> searchStudents(@RequestParam String name,
                                               @RequestParam(required = false) String department,
                                               @RequestParam(required = false) String year) {
        return studentService.searchStudents(name, department, year);
    }

    // Contact faculty advisors
    @GetMapping("/{id}/advisors")
    public List<FacultyProfile> getAdvisors(@PathVariable Long id) {
        return (List<FacultyProfile>) facultyService.getFacultyProfile(id);
    }
}
