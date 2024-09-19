package com.practice.CollegeDirectory.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.practice.CollegeDirectory.Service.AdministratorService;
import com.practice.CollegeDirectory.model.AdministratorProfile;
import com.practice.CollegeDirectory.model.FacultyProfile;
import com.practice.CollegeDirectory.model.StudentProfile;

@RestController
@RequestMapping("/api/admin")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    // CRUD operations for student records
    @PostMapping("/students")
    public StudentProfile addStudent(@RequestBody StudentProfile studentProfile) {
        return administratorService.addStudent( studentProfile);
    }

    @PutMapping("/students/{id}")
    public StudentProfile updateStudent(@PathVariable Long id, @RequestBody StudentProfile updatedProfile) {
        return administratorService.updateStudent(id, updatedProfile);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        administratorService.deleteStudent(id);
        return "Student deleted successfully!";
    }

    // CRUD operations for faculty records
    @PostMapping("/faculty")
    public FacultyProfile addFaculty(@RequestBody FacultyProfile facultyProfile) {
        return administratorService.addFaculty(facultyProfile);
    }

    @PutMapping("/faculty/{id}")
    public FacultyProfile updateFaculty(@PathVariable Long id, @RequestBody FacultyProfile updatedProfile) {
        return administratorService.updateFaculty(id, updatedProfile);
    }

    @DeleteMapping("/faculty/{id}")
    public String deleteFaculty(@PathVariable Long id) {
        administratorService.deleteFaculty(id);
        return "Faculty deleted successfully!";
    }

    // View dashboard with graphical data
    @GetMapping("/dashboard")
    public String viewDashboard() {
        // You can return aggregated data for the dashboard, such as student trends, course loads, etc.
        return administratorService.getDashboardData();
    }
}