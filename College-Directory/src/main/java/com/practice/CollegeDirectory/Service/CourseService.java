package com.practice.CollegeDirectory.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.CollegeDirectory.model.Course;
import com.practice.CollegeDirectory.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Get all courses by department ID
    public List<Course> getCoursesByDepartmentId(Long departmentId) {
        return courseRepository.findByDepartmentId(departmentId);
    }

    // Get all courses taught by a faculty member
    public List<Course> getCoursesByFacultyId(Long facultyId) {
        return courseRepository.findByFacultyId(facultyId);
    }

    // Add, update, delete courses - typical CRUD operations
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long courseId, Course updatedCourse) {
        Course existingCourse = courseRepository.findById(courseId).orElse(null);
        if (existingCourse != null) {
            existingCourse.setTitle(updatedCourse.getTitle());
            existingCourse.setDescription(updatedCourse.getDescription());
            existingCourse.setFaculty(updatedCourse.getFaculty());
            existingCourse.setDepartment(updatedCourse.getDepartment());
            return courseRepository.save(existingCourse);
        }
        return null;
    }

    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
